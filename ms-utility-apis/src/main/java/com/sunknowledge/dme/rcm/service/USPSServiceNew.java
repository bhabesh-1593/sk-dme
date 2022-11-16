package com.sunknowledge.dme.rcm.service;

import com.sunknowledge.dme.rcm.dto.usps.Address;
import com.sunknowledge.dme.rcm.dto.usps.AddressValidateRequest;
import com.sunknowledge.dme.rcm.dto.usps.AddressValidateResponse;
import com.sunknowledge.dme.rcm.exception.USPSExceptionHandler;
import com.sunknowledge.dme.rcm.repository.usps.DPVConfirmationMasterRepository;
import com.sunknowledge.dme.rcm.utils.ApplicationConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.ExecutionException;

@Service
public class USPSServiceNew {
    Logger log = LoggerFactory.getLogger(USPSServiceNew.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient webClient;

    @Autowired
    private DPVConfirmationMasterRepository dpvConfirmationMasterRepository;

    public AddressValidateResponse addressValidateRequest(Address address) throws ExecutionException, InterruptedException {
        AddressValidateResponse addressResponse = new AddressValidateResponse();
        String url = null;
        HttpEntity<String> requestEntity = null;
        try {
            addressValidation(address);
            AddressValidateRequest addressValidateRequest = new AddressValidateRequest();
            addressValidateRequest.setAddress(address);
            addressValidateRequest.setRevision("1");
            addressValidateRequest.setUserId(ApplicationConstants.USPS_USERID);
            String addressRequestXML = addressValidateRequest.generateXML();
            addressRequestXML = addressRequestXML.replaceAll("(<\\?xml.*?\\?>)", "");

            url = ApplicationConstants.USPS_URL + "?" + "API=" + ApplicationConstants.USPS_API_NAME + "&XML=" + addressRequestXML;
            System.out.println("REQUEST URL:" + url);
            HttpHeaders headers = new HttpHeaders();
            requestEntity = new HttpEntity<>(headers);
        } catch (Exception e) {
            USPSExceptionHandler.processOnError(e);
        }
        return webClient.post().uri(url)
            .retrieve()
            .bodyToMono(AddressValidateResponse.class)
            .toFuture().get();
        //return restTemplate.exchange(url, HttpMethod.POST, requestEntity, AddressValidateResponse.class);
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
