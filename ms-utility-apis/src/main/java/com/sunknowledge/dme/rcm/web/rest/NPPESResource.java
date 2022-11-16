package com.sunknowledge.dme.rcm.web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.sunknowledge.dme.rcm.core.ServiceOutcome;
import com.sunknowledge.dme.rcm.dto.nppes.NPPESIndividualsInputCriteria;
import com.sunknowledge.dme.rcm.dto.nppes.NPPESInputNPICriteria;
import com.sunknowledge.dme.rcm.dto.nppes.ResultNPIOutcome;
import com.sunknowledge.dme.rcm.service.NPPESService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nppes")
public class NPPESResource {
    private static final Logger log = LoggerFactory.getLogger(NPPESResource.class);

    @Autowired
    private NPPESService nppesService;

    @ApiOperation(value = "Get NPI Individual Data")
    @GetMapping(path = "/nppesNPIRestIndividualData", produces = "application/json")
    @ResponseBody
    public String nppesNPIRestIndividualData(NPPESInputNPICriteria nppesInputNPICriteria) {
        log.info("=======================POST for NPI Individual Record==========================");
        String resultOutcomeJson = "";
        try {
            NPPESIndividualsInputCriteria nppesIndividualsInputCriteria = new NPPESIndividualsInputCriteria();
            nppesIndividualsInputCriteria = nppesService.setupNullValuesForInputCriterias(nppesIndividualsInputCriteria);
            nppesIndividualsInputCriteria.setNpiNumber(nppesInputNPICriteria.getNpiNumber());
            nppesIndividualsInputCriteria.setEnumerationType("NPI-1");
            ServiceOutcome<ResultNPIOutcome> resultOutcome = nppesService.readNPPESNPIRecord(nppesIndividualsInputCriteria);
            if(resultOutcome != null) {
                nppesService.saveNUpdateNPIData(resultOutcome);
                ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
                resultOutcomeJson = ow.writeValueAsString(resultOutcome.getData().getResultNPIDataset());
            }
            System.out.println("JSON RESULT:"+resultOutcomeJson);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return resultOutcomeJson;
    }

    @ApiOperation(value = "Get NPI Organizational Data")
    @GetMapping(path = "/nppesNPIRestOrganizationalData", produces = "application/json")
    @ResponseBody
    public String nppesNPIRestOrganizationalData(NPPESInputNPICriteria nppesInputNPICriteria) {
        log.info("=======================POST for NPI Organizational Record==========================");
        String resultOutcomeJson = "";
        try {
            NPPESIndividualsInputCriteria nppesIndividualsInputCriteria = new NPPESIndividualsInputCriteria();
            nppesIndividualsInputCriteria = nppesService.setupNullValuesForInputCriterias(nppesIndividualsInputCriteria);
            nppesIndividualsInputCriteria.setNpiNumber(nppesInputNPICriteria.getNpiNumber());
            nppesIndividualsInputCriteria.setEnumerationType("NPI-2");
            ServiceOutcome<ResultNPIOutcome> resultOutcome = nppesService.readNPPESNPIRecord(nppesIndividualsInputCriteria);
            if(resultOutcome != null) {
                ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
                resultOutcomeJson = ow.writeValueAsString(resultOutcome.getData().getResultNPIDataset());
            }
            System.out.println("JSON RESULT:"+resultOutcomeJson);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return resultOutcomeJson;
    }
}
