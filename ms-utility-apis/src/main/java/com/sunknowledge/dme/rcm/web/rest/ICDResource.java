package com.sunknowledge.dme.rcm.web.rest;

import com.sunknowledge.dme.rcm.core.ServiceOutcome;
import com.sunknowledge.dme.rcm.dto.icd.ICDResultOutcome;
import com.sunknowledge.dme.rcm.dto.icd.RequestICDInput;
import com.sunknowledge.dme.rcm.service.ICDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/icd/release")
@Slf4j
public class ICDResource {
	@Autowired
    ICDService icdService;

	@ApiOperation(value = "Get ICD10 Information")
	@GetMapping(path = "/getICD10Information", produces = "application/json")
	@ResponseBody
	public String getICD10Information(RequestICDInput requestICDInput) {
		log.info("=======================POST for ICD 10 Information==========================");
		String resultOutcomeJson = "";
		try {
            //https://icd.who.int/browse10/2019/en#/B15-B19
			String token = icdService.getToken();
			//String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYmYiOjE2NTc3MTA3NDIsImV4cCI6MTY1NzcxNDM0MiwiaXNzIjoiaHR0cHM6Ly9pY2RhY2Nlc3NtYW5hZ2VtZW50Lndoby5pbnQiLCJhdWQiOlsiaHR0cHM6Ly9pY2RhY2Nlc3NtYW5hZ2VtZW50Lndoby5pbnQvcmVzb3VyY2VzIiwiaWNkYXBpIl0sImNsaWVudF9pZCI6ImJkMzhlZTk3LWQxNGUtNGM0NC1iM2QwLTk3MTcwOWMzMGNmMl9hZTI4MTRiNy0xMjQ1LTRkMzMtOTE2Yy1kYjdmYmNiNzNmMTIiLCJzY29wZSI6WyJpY2RhcGlfYWNjZXNzIl19.VZULeJbQY4ZY-F8fBBiSqYiLLcjDAWdhnr7Q7ygK2taFzoigVkmsVW7tnQP4muwmmbkuvejfLJMPln-JVAguCwf1akXGt1_Fww9rLtrcKgpAEK1esiyvws_rBBUe5pBB8mHSV3up89LftBWgwFF_0r8l7TeZKmGB1xZDNVKBC4nq1MG262ZV_pVsaaHqKXLXc-Y9vkHUnvYJskcAv5PKD0aeO0e3DeSK9DRSitCqEHgTS7jFVsmHdFzNS_8nm9lXw6DVLIvlFWWoMjxZcp1zvKrQb0w3yQF23bubss-8ta-HurGLcohyurG5nZrg6IzH6HnctVF3w7J2wX5Kg83asg";
			System.out.println("CONTROLLER TOKEN:"+token);
			ServiceOutcome<ICDResultOutcome> serviceOutcome = icdService.getICD10Information(requestICDInput, token);
			System.out.println("JSON RESULT:"+serviceOutcome);
			if(serviceOutcome != null) {
				ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
				resultOutcomeJson = ow.writeValueAsString(serviceOutcome);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return resultOutcomeJson;
	}
}
