package com.sunknowledge.dme.rcm.service;

import com.sunknowledge.dme.rcm.domain.usps.DPVConfirmationMaster;
import com.sunknowledge.dme.rcm.dto.usps.Address;
import com.sunknowledge.dme.rcm.dto.usps.AddressValidateRequest;
import com.sunknowledge.dme.rcm.dto.usps.AddressValidateResponse;
import com.sunknowledge.dme.rcm.exception.USPSExceptionHandler;
import com.sunknowledge.dme.rcm.repository.usps.*;
import com.sunknowledge.dme.rcm.utils.ApplicationConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class USPSService {
    Logger log = LoggerFactory.getLogger(USPSService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private FootnoteMasterRepository footnoteMasterRepository;

    @Autowired
    private DPVConfirmationMasterRepository dpvConfirmationMasterRepository;

    @Autowired
    private DPVFootnotesMasterRepository dpvFootnotesMasterRepository;

    @Autowired
    private USPSStateMasterRepository stateMasterRepository;

    @Autowired
    private UrbanizationMasterRepository urbanizationMasterRepository;

    public AddressValidateResponse addressValidateRequest(Address address) {
        AddressValidateResponse addressResponse = new AddressValidateResponse();
        try {
            addressValidation(address);
            AddressValidateRequest addressValidateRequest = new AddressValidateRequest();
            addressValidateRequest.setAddress(address);
            addressValidateRequest.setRevision("1");
            addressValidateRequest.setUserId(ApplicationConstants.USPS_USERID);
            //addressValidateRequest.setId("0");
            String addressRequestXML = addressValidateRequest.generateXML();
            addressRequestXML = addressRequestXML.replaceAll("(<\\?xml.*?\\?>)","");

            String url = ApplicationConstants.USPS_URL+"?"+"API="+ApplicationConstants.USPS_API_NAME+"&XML="+addressRequestXML;
            System.out.println("REQUEST URL:"+url);

            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> requestEntity = new HttpEntity<>(headers);
            ResponseEntity<AddressValidateResponse> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, AddressValidateResponse.class);

            if(response.getStatusCodeValue() == 200) {
                if(response.getBody().getAddress().getCentralDeliveryPoint() != null) {
                    Address addressResult = response.getBody().getAddress();
                    addressResponse = new AddressValidateResponse();
                    addressResponse.setAddress(addressResult);

                    if(addressResult.getFootnotes() != null && addressResult.getFootnotes().length() > 0 && addressResult.getFootnotes().length() >= 1) {
                        String[] array = addressResult.getFootnotes().split("(?<=\\G.{1})");
                        String footnotes = "";
                        for(String arr : array) {
                            if(footnotes.equals(""))
                                footnotes = footnoteMasterRepository.getFootnoteDetailsByEnumerations(arr).toFuture().get().getDefinition();
                            else
                                footnotes = footnotes +"-/-"+ footnoteMasterRepository.getFootnoteDetailsByEnumerations(arr).toFuture().get().getDefinition();
                        }
                        addressResponse.setFootnotesDefinition(footnotes);
                    }
                    else {
                        addressResponse.setFootnotesDefinition("NA");
                    }

                    Mono<DPVConfirmationMaster> dpvConfirmationDefinition = dpvConfirmationMasterRepository.getDPVConfirmationDetailsByEnumerations(addressResult.getDpvConfirmation());
                    addressResponse.setDpvConfirmationDefinition(dpvConfirmationDefinition.toFuture().get().getDefinition());

                    if(addressResult.getDpvFootnotes().length() > 0 && addressResult.getDpvFootnotes().length() > 2) {
                        String[] array = addressResult.getDpvFootnotes().split("(?<=\\G.{2})");
                        String dpvFootnotes = "";
                        for(String arr : array) {
                            if(dpvFootnotes.equals(""))
                                dpvFootnotes = dpvFootnotesMasterRepository.getDPVFootnoteDetailsByDefinition(arr).toFuture().get().getEnumerations();
                            else
                                dpvFootnotes = dpvFootnotes +"-/-"+ dpvFootnotesMasterRepository.getDPVFootnoteDetailsByDefinition(arr).toFuture().get().getEnumerations();
                        }
                        addressResponse.setDpvFootnotesDefinition(dpvFootnotes);
                    }
                    else {
                        addressResponse.setDpvFootnotesDefinition("NA");
                    }

                    if(addressResult.getDpvcmra().equals("Y")) {
                        addressResponse.setDpvcmra("Address was found in the CMRA table.");
                    }
                    if(addressResult.getDpvcmra().equals("N")) {
                        addressResponse.setDpvcmra("Address was not found in the CMRA table.");
                    }

                    if(addressResult.getBusiness().equals("Y"))
                        addressResponse.setBusiness("Business");
                    if(addressResult.getBusiness().equals("N"))
                        addressResponse.setBusiness("Not Business");

                    if(addressResult.getCentralDeliveryPoint().equals("Y"))
                        addressResponse.setCentralDeliveryPoint("Central Delivery Available");
                    if(addressResult.getCentralDeliveryPoint().equals("N"))
                        addressResponse.setCentralDeliveryPoint("Central Delivery not Available");

                    if(addressResult.getVacant().equals("Y"))
                        addressResponse.setVacant("Location is Occupied");
                    if(addressResult.getVacant().equals("N"))
                        addressResponse.setVacant("Location is not Occupied");


                    if(addressResult.getDpvConfirmation().equals("N")) {
                        addressResponse.setMessage("Not a Valid Address");
                        addressResponse.setMessageCode("NV");
                    }
                    else {
                        addressResponse.setMessage("Valid Address");
                        addressResponse.setMessageCode("VA");
                    }
                }
                else {
                    addressResponse = new AddressValidateResponse();
                    Address noAddress = new Address();
                    noAddress.setFirmName("NA");
                    noAddress.setAddress1("NA");
                    noAddress.setAddress2("NA");
                    noAddress.setCity("NA");
                    noAddress.setState("NA");
                    noAddress.setUrbanization("NA");
                    noAddress.setZip5("NA");
                    noAddress.setZip4("NA");
                    noAddress.setDeliveryPoint("NA");
                    noAddress.setCarrierRoute("NA");
                    addressResponse.setAddress(noAddress);
                    addressResponse.setBusiness("NA");
                    addressResponse.setCentralDeliveryPoint("NA");
                    addressResponse.setDpvcmra("NA");
                    addressResponse.setDpvConfirmationDefinition("NA");
                    addressResponse.setDpvFootnotesDefinition("NA");
                    addressResponse.setFootnotesDefinition("NA");
                    addressResponse.setMessage("ADDRESS NOT FOUND");
                    addressResponse.setMessage("NA");
                    addressResponse.setVacant("NA");
                }
            }
            else{
                System.out.println("============ELSE================");
            }
        }
        catch(Exception e) {
            USPSExceptionHandler.processOnError(e);
        }
        return addressResponse;
    }

    public String bindXMLQuery(String apiName, String addressRequestXML) {
        String xmlQuery = "";
        xmlQuery = String.format("API=%s&XML=%s", URLEncoder.encode(apiName, StandardCharsets.UTF_8), URLEncoder.encode(addressRequestXML, StandardCharsets.UTF_8));
        System.out.println("XML QUERY=>"+xmlQuery);
        return xmlQuery;
    }

    public Address createUSPSAddress(Address address) {
        try {
            if(address.getAddress1() == null)
                address.setAddress1("");
            if(address.getAddress2() == null)
                address.setAddress2("");
            if(address.getCity() == null)
                address.setCity("");
            if(address.getState() == null)
                address.setState("");
            if(address.getZip5() == null)
                address.setZip5("");
            if(address.getZip4() == null)
                address.setZip4("");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return address;
    }

    public Address addressValidation(Address address){
        if(address.getAddress2().equals(""))
            address.setAddress2(address.getCity());
        return address;
    }
}
