package com.sunknowledge.dme.rcm.web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.sunknowledge.dme.rcm.dto.usps.Address;
import com.sunknowledge.dme.rcm.dto.usps.AddressValidateResponse;
import com.sunknowledge.dme.rcm.service.USPSService;
import com.sunknowledge.dme.rcm.service.USPSServiceNew;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/usps")
public class USPSResourceNew {
    @Autowired
    private USPSServiceNew uspsService;

    private static final Logger logger = LoggerFactory.getLogger(USPSResourceNew.class);
    @ApiOperation(value = "Address Validate Request Service")
    @GetMapping("addressValidateRequestService")
    @ResponseBody
    public AddressValidateResponse addressValidateRequest(Address address) {
        String resultOutcomeJson = "";
        AddressValidateResponse addressValidateResponse = null;
        try {
            address = uspsService.createUSPSAddress(address);
            addressValidateResponse = uspsService.addressValidateRequest(address);

            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            resultOutcomeJson = ow.writeValueAsString(addressValidateResponse);
            System.out.println("RESULT OUTPUT JSON=>" + resultOutcomeJson);
        } catch (Exception e) {
            logger.info("-------------ERROR on USPS address validation---------------");
            e.printStackTrace();
        }
        return addressValidateResponse;
    }
}
