package com.sunknowledge.dme.rcm.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sunknowledge.dme.rcm.core.ServiceOutcome;
import com.sunknowledge.dme.rcm.domain.nppes.NpiMaster;
import com.sunknowledge.dme.rcm.dto.nppes.*;
import com.sunknowledge.dme.rcm.repository.nppes.CountryMasterRepository;
import com.sunknowledge.dme.rcm.repository.nppes.NpiMasterRepository;
import com.sunknowledge.dme.rcm.repository.nppes.StateMasterRepository;
import com.sunknowledge.dme.rcm.utils.ApplicationConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class NPPESService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CountryMasterRepository countryMasterRepository;

    @Autowired
    private StateMasterRepository stateMasterRepository;

    @Autowired
    private NpiMasterRepository npiMasterRepository;

    public String generateQueryParameter(NPPESIndividualsInputCriteria nppesIndividualsInputCriteria) {
        String queryParameters = "";
        NPPESIndividualsInputCriteria inputParameters = new NPPESIndividualsInputCriteria();
        if(!nppesIndividualsInputCriteria.getAddressPurpose().equals("") || nppesIndividualsInputCriteria.getAddressPurpose() != null) {
            inputParameters.setAddressPurpose(nppesIndividualsInputCriteria.getAddressPurpose());
            queryParameters = queryParameters+"address_purpose="+nppesIndividualsInputCriteria.getAddressPurpose()+"&";
        }
        if(!nppesIndividualsInputCriteria.getCity().equals("") || nppesIndividualsInputCriteria.getCity() != null) {
            inputParameters.setCity(nppesIndividualsInputCriteria.getCity());
            queryParameters = queryParameters+"city="+nppesIndividualsInputCriteria.getCity()+"&";
        }
        if(!nppesIndividualsInputCriteria.getCountryCode().equals("") || nppesIndividualsInputCriteria.getCountryCode() != null) {
            inputParameters.setCountryCode(nppesIndividualsInputCriteria.getCountryCode());
            queryParameters = queryParameters+"country_code="+nppesIndividualsInputCriteria.getCountryCode()+"&";
        }
        if(!nppesIndividualsInputCriteria.getEnumerationType().equals("") || nppesIndividualsInputCriteria.getEnumerationType() != null) {
            inputParameters.setEnumerationType(nppesIndividualsInputCriteria.getEnumerationType());
            queryParameters = queryParameters+"enumeration_type="+nppesIndividualsInputCriteria.getEnumerationType()+"&";
        }
        if(!nppesIndividualsInputCriteria.getFirstName().equals("") || nppesIndividualsInputCriteria.getFirstName() != null) {
            inputParameters.setFirstName(nppesIndividualsInputCriteria.getFirstName());
            queryParameters = queryParameters+"first_name="+nppesIndividualsInputCriteria.getFirstName()+"&";
        }
        if(!nppesIndividualsInputCriteria.getLastName().equals("") || nppesIndividualsInputCriteria.getLastName() != null) {
            inputParameters.setLastName(nppesIndividualsInputCriteria.getLastName());
            queryParameters = queryParameters+"last_name="+nppesIndividualsInputCriteria.getLastName()+"&";
        }
        if(!nppesIndividualsInputCriteria.getLimit().equals("") || nppesIndividualsInputCriteria.getLimit() != null) {
            inputParameters.setLimit(nppesIndividualsInputCriteria.getLimit());
            queryParameters = queryParameters+"limit="+nppesIndividualsInputCriteria.getLimit()+"&";
        }
        if(!nppesIndividualsInputCriteria.getNpiNumber().equals("") || nppesIndividualsInputCriteria.getNpiNumber() != null) {
            inputParameters.setNpiNumber(nppesIndividualsInputCriteria.getNpiNumber());
            queryParameters = queryParameters+"number="+nppesIndividualsInputCriteria.getNpiNumber()+"&";
        }
        if(!nppesIndividualsInputCriteria.getOrganizationName().equals("") || nppesIndividualsInputCriteria.getOrganizationName() != null) {
            inputParameters.setOrganizationName(nppesIndividualsInputCriteria.getOrganizationName());
            queryParameters = queryParameters+"organization_name="+nppesIndividualsInputCriteria.getOrganizationName()+"&";
        }
        if(!nppesIndividualsInputCriteria.getPostalCode().equals("") || nppesIndividualsInputCriteria.getPostalCode() != null) {
            inputParameters.setPostalCode(nppesIndividualsInputCriteria.getPostalCode());
            queryParameters = queryParameters+"postal_code="+nppesIndividualsInputCriteria.getPostalCode()+"&";
        }
        if(!nppesIndividualsInputCriteria.getState().equals("") || nppesIndividualsInputCriteria.getState() != null) {
            inputParameters.setState(nppesIndividualsInputCriteria.getState());
            queryParameters = queryParameters+"state="+nppesIndividualsInputCriteria.getState()+"&";
        }
        if(!nppesIndividualsInputCriteria.getTaxonomyDescription().equals("") || nppesIndividualsInputCriteria.getTaxonomyDescription() != null) {
            inputParameters.setTaxonomyDescription(nppesIndividualsInputCriteria.getTaxonomyDescription());
            queryParameters = queryParameters+"taxonomy_description="+nppesIndividualsInputCriteria.getTaxonomyDescription()+"&";
        }
        if(nppesIndividualsInputCriteria.getPretty() != null) {
            if(nppesIndividualsInputCriteria.getPretty().equals("true") || nppesIndividualsInputCriteria.getPretty().equals("on")) {
                inputParameters.setPretty("on");
                queryParameters = queryParameters+"pretty="+inputParameters.getPretty()+"&";
            }
        }
        queryParameters = queryParameters+"version="+ ApplicationConstants.NPPES_VERSION;
        return queryParameters;
    }

    /*public Flux<CountryMaster> getAllCountryList(){
        return countryMasterRepository.findAll();
    }

    public Flux<StateMaster> getAllStateList(){
        return stateMasterRepository.findAll();
    }*/

    public ServiceOutcome<ResultNPIOutcome> readNPPESNPIRecord(NPPESIndividualsInputCriteria nppesIndividualsInputCriteria){
        NPISuccessOutcome npiSuccessOutcome = null;
        NPIFailureOutcome npiFailureOutcome = null;
        List<ResultNPIDataset> resultOutcome = null;
        ResultNPIOutcome resultNPIOutcome = new ResultNPIOutcome();
        ServiceOutcome<ResultNPIOutcome> routcome = new ServiceOutcome<ResultNPIOutcome>();
        try {
            String queryParameters = generateQueryParameter(nppesIndividualsInputCriteria);
            String url = ApplicationConstants.NPPES_URL+"?"+queryParameters;
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> requestEntity = new HttpEntity<>(headers);

            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
            log.info("RESPONSE:"+response);
            ObjectMapper mapper = new ObjectMapper();
            if(response.getStatusCodeValue() == 200) {
                npiSuccessOutcome = mapper.readValue(response.getBody(), NPISuccessOutcome.class);
                System.out.println("Result Count:"+npiSuccessOutcome.getResultCount());

                resultOutcome = new ArrayList<ResultNPIDataset>();
                if(npiSuccessOutcome.getResultCount() != null) {
                    if(npiSuccessOutcome.getResultCount() > 0 && npiSuccessOutcome.getResults() != null) {
                        for(int i = 0; i < npiSuccessOutcome.getResults().size(); i++) {
                            ResultNPIDataset outcome = new ResultNPIDataset();
                            outcome.setResultCount(npiSuccessOutcome.getResultCount());
                            outcome.setNpiNumber(npiSuccessOutcome.getResults().get(i).getNumber().toString());
                            outcome.setNpiName(npiSuccessOutcome.getResults().get(i).getBasic().getName());
                            if(npiSuccessOutcome.getResults().get(i).getEnumerationType().equals("NPI-1"))
                                outcome.setEnumerationType("Individual NPI");
                            if(npiSuccessOutcome.getResults().get(i).getEnumerationType().equals("NPI-2"))
                                outcome.setEnumerationType("Organizational NPI");
                            for(int j = 0; j < npiSuccessOutcome.getResults().get(i).getAddresses().size(); j++){
                                outcome.setAddress(npiSuccessOutcome.getResults().get(i).getAddresses().get(0).getAddress1()+" "+npiSuccessOutcome.getResults().get(i).getAddresses().get(0).getAddress2()+"\n"+npiSuccessOutcome.getResults().get(i).getAddresses().get(0).getCity()+","+npiSuccessOutcome.getResults().get(i).getAddresses().get(0).getState()+" "+npiSuccessOutcome.getResults().get(i).getAddresses().get(0).getPostalCode());
                                outcome.setPhone(npiSuccessOutcome.getResults().get(i).getAddresses().get(0).getTelephoneNumber());
                            }
                            if(npiSuccessOutcome.getResults().get(i).getTaxonomies().size() >= 1) {
                                for(int k = 0; k < npiSuccessOutcome.getResults().get(i).getTaxonomies().size(); k++){
                                    if(npiSuccessOutcome.getResults().get(i).getTaxonomies().get(k).getPrimary() == true) {
                                        Taxonomy taxonomy = new Taxonomy();
                                        taxonomy.setCode(npiSuccessOutcome.getResults().get(i).getTaxonomies().get(k).getCode());
                                        taxonomy.setDesc(npiSuccessOutcome.getResults().get(i).getTaxonomies().get(k).getDesc());
                                        taxonomy.setLicense(npiSuccessOutcome.getResults().get(i).getTaxonomies().get(k).getLicense());
                                        taxonomy.setPrimary(npiSuccessOutcome.getResults().get(i).getTaxonomies().get(k).getPrimary());
                                        taxonomy.setState(npiSuccessOutcome.getResults().get(i).getTaxonomies().get(k).getState());
                                        outcome.setPrimaryTaxonomy(taxonomy);
                                        if(!npiSuccessOutcome.getResults().get(i).getTaxonomies().get(k).getCode().equals("") && npiSuccessOutcome.getResults().get(i).getBasic().getStatus().equalsIgnoreCase("A"))
                                            outcome.setStatus(true);
                                        else
                                            outcome.setStatus(false);
                                    }
                                }
                            }
                            else {
                                outcome.setPrimaryTaxonomy(null);
                                outcome.setStatus(false);
                            }
                            outcome.setBasicDetails(npiSuccessOutcome.getResults().get(i).getBasic());
                            outcome.setAddressList(npiSuccessOutcome.getResults().get(i).getAddresses());
                            outcome.setOtherNamesList(npiSuccessOutcome.getResults().get(i).getOtherNames());
                            outcome.setEndpoints(npiSuccessOutcome.getResults().get(i).getEndpoints());
                            outcome.setPracticeLocations(npiSuccessOutcome.getResults().get(i).getPracticeLocations());
                            resultOutcome.add(outcome);
                            routcome.setMessage("SUCCESS");
                            routcome.setOutcome(true);
                        }
                    }
                    else if(npiSuccessOutcome.getResultCount() == 0) {
                        ResultNPIDataset outcome = new ResultNPIDataset();
                        outcome.setResultCount(0);
                        outcome.setNpiNumber("");
                        outcome.setNpiName("");
                        outcome.setEnumerationType("");
                        outcome.setAddress("");
                        outcome.setPhone("");
                        outcome.setPrimaryTaxonomy(null);
                        outcome.setStatus(false);
                        outcome.setBasicDetails(null);
                        outcome.setAddressList(null);
                        outcome.setOtherNamesList(null);
                        outcome.setEndpoints(null);
                        outcome.setPracticeLocations(null);
                        resultOutcome.add(outcome);
                        routcome.setMessage("SUCCESS");
                        routcome.setOutcome(true);
                    }
                    else {
                        npiFailureOutcome = mapper.readValue(response.getBody(), NPIFailureOutcome.class);
                        if(npiFailureOutcome != null) {
                            List<ErrorMessage> errorMessageList = new ArrayList<ErrorMessage>();
                            ResultNPIDataset outcome = new ResultNPIDataset();
                            for(ErrorMessage errorMsg: npiFailureOutcome.getErrors()) {
                                ErrorMessage errorMessage = new ErrorMessage();
                                errorMessage.setDescription(errorMsg.getDescription());
                                errorMessage.setField(errorMsg.getField());
                                errorMessage.setNumber(errorMsg.getNumber());
                                errorMessageList.add(errorMessage);
                            }
                            outcome.setError(errorMessageList);
                            resultOutcome.add(outcome);
                            routcome.setMessage("Improper Data Input.");
                            routcome.setOutcome(false);
                        }
                    }
                }
                else {
                    npiFailureOutcome = mapper.readValue(response.getBody(), NPIFailureOutcome.class);
                    if(npiFailureOutcome != null) {
                        List<ErrorMessage> errorMessageList = new ArrayList<ErrorMessage>();
                        ResultNPIDataset outcome = new ResultNPIDataset();
                        for(ErrorMessage errorMsg: npiFailureOutcome.getErrors()) {
                            ErrorMessage errorMessage = new ErrorMessage();
                            errorMessage.setDescription(errorMsg.getDescription());
                            errorMessage.setField(errorMsg.getField());
                            errorMessage.setNumber(errorMsg.getNumber());
                            errorMessageList.add(errorMessage);
                        }
                        outcome.setError(errorMessageList);
                        resultOutcome.add(outcome);
                        routcome.setMessage("Improper Data Input.");
                        routcome.setOutcome(false);
                    }
                }
            }
            resultNPIOutcome.setResultNPIDataset(resultOutcome);
            routcome.setData(resultNPIOutcome);
            routcome.setMessage(url);
            routcome.setOutcome(null);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return routcome;
    }

    public NPPESIndividualsInputCriteria prepareQueryParameter(String addressPurpose, String city, String countryCode, String enumerationType, String firstName, String lastName, String limit, String number,
                                                               String organizationName, String postalCode, String state, String taxonomyDescription, String pretty) {
        NPPESIndividualsInputCriteria nppesIndividualsInputCriteria = new NPPESIndividualsInputCriteria();
        if(addressPurpose != null)
            nppesIndividualsInputCriteria.setAddressPurpose(addressPurpose);
        if(city != null)
            nppesIndividualsInputCriteria.setCity(city);
        if(countryCode != null)
            nppesIndividualsInputCriteria.setCountryCode(countryCode);
        if(enumerationType != null)
            nppesIndividualsInputCriteria.setEnumerationType(enumerationType);
        if(firstName != null)
            nppesIndividualsInputCriteria.setFirstName(firstName);
        if(lastName != null)
            nppesIndividualsInputCriteria.setLastName(lastName);
        if(limit != null)
            nppesIndividualsInputCriteria.setLimit(limit);
        if(number != null)
            nppesIndividualsInputCriteria.setNpiNumber(number);
        if(organizationName != null)
            nppesIndividualsInputCriteria.setOrganizationName(organizationName);
        if(postalCode != null)
            nppesIndividualsInputCriteria.setPostalCode(postalCode);
        if(state != null)
            nppesIndividualsInputCriteria.setState(state);
        if(taxonomyDescription != null)
            nppesIndividualsInputCriteria.setTaxonomyDescription(taxonomyDescription);
        if(pretty != null) {
            if(pretty.equals("on")) {
                nppesIndividualsInputCriteria.setPretty("on");
            }
        }

        return nppesIndividualsInputCriteria;
    }

    public NPPESIndividualsInputCriteria setupNullValuesForInputCriterias(NPPESIndividualsInputCriteria nppesIndividualsInputCriteria) {
        nppesIndividualsInputCriteria.setAddressPurpose("");
        nppesIndividualsInputCriteria.setCity("");
        nppesIndividualsInputCriteria.setCountryCode("");
        nppesIndividualsInputCriteria.setEnumerationType("");
        nppesIndividualsInputCriteria.setFirstName("");
        nppesIndividualsInputCriteria.setLastName("");
        nppesIndividualsInputCriteria.setLimit("");
        nppesIndividualsInputCriteria.setNpiNumber("");
        nppesIndividualsInputCriteria.setOrganizationName("");
        nppesIndividualsInputCriteria.setPostalCode("");
        nppesIndividualsInputCriteria.setState("");
        nppesIndividualsInputCriteria.setTaxonomyDescription("");
        nppesIndividualsInputCriteria.setPretty("");
        return nppesIndividualsInputCriteria;
    }

    public void saveNUpdateNPIData(ServiceOutcome<ResultNPIOutcome> resultOutcome) throws Exception{
        //Mono<NpiMaster> npiMaster = npiMasterRepository.getNpiNumberByNpiNumber(resultOutcome.getData().getResultNPIDataset().get(0).getNpiNumber());
        Mono<NpiMaster> npiMaster = npiMasterRepository.getNpiNumberByNpiNumber(resultOutcome.getData().getResultNPIDataset().get(0).getNpiNumber());
        if(!npiMaster.hasElement().toFuture().get()) {
            System.out.println("=====================SAVE=========================");
            NpiMaster saveNpiMaster = new NpiMaster();
            saveNpiMaster.setNpiNumber(resultOutcome.getData().getResultNPIDataset().get(0).getNpiNumber());

            saveNpiMaster.setAddress(resultOutcome.getData().getResultNPIDataset().get(0).getAddress());
            saveNpiMaster.setEnumerationType(resultOutcome.getData().getResultNPIDataset().get(0).getEnumerationType());
            saveNpiMaster.setPhone(resultOutcome.getData().getResultNPIDataset().get(0).getPhone());

            Mono<NpiMaster> newNpiMaster = npiMasterRepository.save(saveNpiMaster);
        }
        else{
            System.out.println("====================UPDATE======================="+npiMaster.toFuture().get().getNpiId());
            NpiMaster updateNpiMaster = new NpiMaster();
            updateNpiMaster = npiMaster.toFuture().get();
            if (Objects.nonNull(updateNpiMaster.getNpiName())) {
                updateNpiMaster.setNpiName(updateNpiMaster.getNpiName());
            }
            else {
                updateNpiMaster.setNpiName("No Name Defined");
            }
            Mono<NpiMaster> newNpiMaster = npiMasterRepository.save(updateNpiMaster);
        }
    }
}
