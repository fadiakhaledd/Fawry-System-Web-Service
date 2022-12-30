package com.FawrySystem.FawrySystemService.serviceProviderPackage.controllers;


import com.FawrySystem.FawrySystemService.formsPackage.forms.*;
import com.FawrySystem.FawrySystemService.transactionsPackage.models.Transaction;
import com.FawrySystem.FawrySystemService.usersPackage.controllers.CustomerController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.FawrySystem.FawrySystemService.serviceProviderPackage.BSL.*;

@Component
@RestController
@RequestMapping("orange")
public class OrangeSPController {

    PhoneServiceProvidersBSL providersBSL = new PhoneServiceProvidersBSL();

    @PostMapping(value = "internetPayment", consumes = {"application/json"})
    public ResponseEntity<Object> OrangeInternetPayment(@RequestBody PhoneForm form){

        if (CustomerController.currentCustomer == null)
            return new ResponseEntity<>("Login as a customer", HttpStatus.UNAUTHORIZED);

        Transaction createdTransaction = providersBSL.invokePhoneServiceProvider(form, 1, "Orange");
        if (createdTransaction != null) {
            return new ResponseEntity<>(createdTransaction, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "mobileRecharge", consumes = {"application/json"})
    public ResponseEntity<Object> OrangeMobileRecharge(@RequestBody PhoneForm form){

        if (CustomerController.currentCustomer == null)
            return new ResponseEntity<>("Login as a customer", HttpStatus.UNAUTHORIZED);

        Transaction createdTransaction = providersBSL.invokePhoneServiceProvider(form, 2, "Orange");
        if (createdTransaction != null) {
            return new ResponseEntity<>(createdTransaction, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }



}
