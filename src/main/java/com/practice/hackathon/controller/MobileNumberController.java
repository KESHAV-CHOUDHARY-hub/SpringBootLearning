package com.practice.hackathon.controller;

import com.practice.hackathon.dto.StatusEnum;
import com.practice.hackathon.exception.MobileNumbersNotAddedException;
import com.practice.hackathon.response.Response;
import com.practice.hackathon.serviceImpl.MobileNumberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class MobileNumberController {

    @Autowired
    MobileNumberServiceImpl service;
// COMMIT TEST

    //test for commit
    @GetMapping("/Numbers")
    public ResponseEntity<Response> getAllNumbers() throws MobileNumbersNotAddedException {
        {
            HttpStatus httpstatus=null;
            Response response= service.getAllNumbers();
            if(!Objects.isNull(response) && !response.getApiStatus().equals(StatusEnum.SUCCESS)) {
                httpstatus=HttpStatus.NOT_FOUND;
            }
            else {
                httpstatus=HttpStatus.OK;
            }
            return new ResponseEntity<>(response,httpstatus);
        }
    }

    // for dummy data  adding purpose
    @PostMapping("/Numbers")
    public String saveAllNumbers() {
        return service.saveAllNumbers();
    }

    @PutMapping("/Numbers")
    public String updateAvailabilityOfNumber(@RequestParam int numberId) {
        return service.updateAvailabilityOfNumber(numberId);
    }
}
