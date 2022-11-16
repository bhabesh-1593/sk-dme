package com.sunknowledge.dme.rcm.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import com.sunknowledge.dme.rcm.core.ServiceOutcome;
import com.sunknowledge.dme.rcm.dto.icd.ICDResultOutcome;
import com.sunknowledge.dme.rcm.dto.icd.RequestICDInput;
import com.sunknowledge.dme.rcm.dto.icd.ResponseOutcome;
import com.sunknowledge.dme.rcm.utils.ApplicationConstants;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ICDService {
	@Autowired
	private RestTemplate restTemplate;

	public String getToken() throws Exception {
		log.info("Getting token...");

		URL url = new URL(ApplicationConstants.ICD_TOKENENDPOINT);
		HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
		con.setRequestMethod("POST");

		// set parameters to post
		String urlParameters =
				"client_id=" + URLEncoder.encode(ApplicationConstants.ICD_CLIENTID, StandardCharsets.UTF_8) +
				"&client_secret=" + URLEncoder.encode(ApplicationConstants.ICD_CLIENTSECRET, StandardCharsets.UTF_8) +
				"&scope=" + URLEncoder.encode(ApplicationConstants.ICD_SCOPE, StandardCharsets.UTF_8) +
				"&grant_type=" + URLEncoder.encode(ApplicationConstants.ICD_GRANT_TYPE, StandardCharsets.UTF_8);
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		// response
		int responseCode = con.getResponseCode();
		log.info("Token Response Code : " + responseCode + "\n");

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuilder response = new StringBuilder();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// parse JSON response
		JSONObject jsonObj = new JSONObject(response.toString());
		return jsonObj.getString("access_token");
	}

	public ServiceOutcome<ICDResultOutcome> getICD10Information(RequestICDInput requestICDInput, String accessToken){
		ServiceOutcome<ICDResultOutcome> serviceOutcome = new ServiceOutcome<ICDResultOutcome>();
		try {
			String uri = ApplicationConstants.ICD_URI+"/"+requestICDInput.getReleaseId()+"/"+requestICDInput.getCode();
			HttpHeaders headers = new HttpHeaders();
			headers.add("API-Version", ApplicationConstants.ICD_API_VERSION);
			headers.add("Accept-Language", ApplicationConstants.ICD_ACCEPT_LANGUAGE);
			headers.set("Authorization", "Bearer "+accessToken);
			HttpEntity<String> requestEntity = new HttpEntity<>(headers);
			ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
			log.info("RESPONSE:"+responseEntity);
			if(responseEntity.getStatusCode() == HttpStatus.OK) {
				ObjectMapper mapper = new ObjectMapper();
				ResponseOutcome response;
				response = mapper.readValue(responseEntity.getBody(), ResponseOutcome.class);
				ICDResultOutcome resultOutcome = new ICDResultOutcome();
				resultOutcome.setBrowserUrl(response.getBrowserUrl());

				if(response.getChild() != null && response.getChild().size() > 0) {
					List<String> diseasesList = new ArrayList<String>();
					List<String> childList = new ArrayList<String>();
					for(int i = 0; i < response.getChild().size(); i++) {
						String s1 = response.getChild().get(i).substring(response.getChild().get(i).lastIndexOf("/") + 1);
						diseasesList.add(i, s1);
						childList.add(i, response.getChild().get(i));
					}
					resultOutcome.setChild(childList);
					resultOutcome.setDiseasesList(diseasesList);
				}

				resultOutcome.setClassKind(response.getClassKind());
				resultOutcome.setCode(response.getCode());

				if(response.getCodingHint() != null && response.getCodingHint().size() > 0) {
					List<String> codingHintValues = new ArrayList<String>();
					for(int i = 0; i < response.getCodingHint().size(); i++) {
						codingHintValues.add(i, response.getCodingHint().get(i).getLabel().getValue());
					}
					resultOutcome.setCodingHints(codingHintValues);
				}

				resultOutcome.setContext(response.getContext());

				if(response.getExclusion() != null && response.getExclusion().size() > 0) {
					List<String> exclusionValues = new ArrayList<String>();
					for(int i = 0; i < response.getExclusion().size(); i++) {
						exclusionValues.add(i, response.getExclusion().get(i).getLabel().getValue());
					}
					resultOutcome.setExclusionValues(exclusionValues);
				}

				resultOutcome.setId(response.getId());

				if(response.getInclusion() != null && response.getInclusion().size() > 0) {
					List<String> inclusionValues = new ArrayList<String>();
					for(int i = 0; i < response.getInclusion().size(); i++) {
						inclusionValues.add(i, response.getInclusion().get(i).getLabel().getValue());
					}
					resultOutcome.setInclusionValues(inclusionValues);
				}

				if(response.getParent() != null && response.getParent().size() > 0) {
					List<String> parentList = new ArrayList<String>();
					for(int i = 0; i < response.getParent().size(); i++) {
						parentList.add(i, response.getParent().get(i));
					}
					resultOutcome.setParent(parentList);
				}
				resultOutcome.setTitleValue(response.getTitle().getValue());


				serviceOutcome.setData(resultOutcome);
				serviceOutcome.setMessage("Successfully accessed ICD 10 information.");
				serviceOutcome.setOutcome(true);
			}
			else {
				serviceOutcome.setData(null);
				serviceOutcome.setMessage("Failed to accesse ICD 10 information.");
				serviceOutcome.setOutcome(false);
			}
		}
		catch (HttpClientErrorException re) {
			if(HttpStatus.NOT_FOUND.equals(re.getStatusCode())) {
				log.info("404:NOT FOUND");
				serviceOutcome.setData(null);
				serviceOutcome.setMessage("Requested resource could not be found");
				serviceOutcome.setOutcome(false);
			}
			else if(HttpStatus.UNAUTHORIZED.equals(re.getStatusCode())) {
				log.info("401:UNAUTHORIZED");
				serviceOutcome.setData(null);
				serviceOutcome.setMessage("Unauthorized, Token gets expired");
				serviceOutcome.setOutcome(false);
			}
			else {
				log.info("OK");
			}
		}
		catch(Exception e) {
			//e.printStackTrace();
			serviceOutcome.setData(null);
			serviceOutcome.setMessage("Requested resource could not be found");
			serviceOutcome.setOutcome(false);
		}
		return serviceOutcome;
	}
}
