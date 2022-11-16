package com.sunknowledge.dme.rcm.service.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesOrderOutputDTO {
    private Long sid;
    private String sno;
    private String pId;
    private String pFirstName;
    private String pMiddleName;
    private String pLastName;
    private String pSsn;
    private String pGender;
    private LocalDate pDob;
    private String pInsurerName;
    private String pAddresLine1;
    private String pAddressLine2;
    private String pCity;
    private String pState;
    private String pPhone1;
    private String pPhone2;
    private String status;
    private String oStatus;
    private LocalDateTime cDate;
    private Long cById;
    private String cByName;
    private Long confirmationById;
    private String confirmationByName;
    private String pBranchName;
    private String fid;
    private String fname;
    private String fNpi;
    private LocalDate confirmationDate;
    private LocalDate deliveryScheduleDatetime;
    private LocalDate deliveryActualDatetime;

}
