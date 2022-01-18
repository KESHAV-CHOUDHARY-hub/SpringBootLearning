package com.practice.hackathon.controller;

import com.practice.hackathon.dto.StatusEnum;
import com.practice.hackathon.entity.Plan;
import com.practice.hackathon.exception.PlansNotAddedException;
import com.practice.hackathon.response.Response;
import com.practice.hackathon.serviceImpl.PlansServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Objects;

@RestController
public class PlansController {

    @Autowired
    PlansServiceImpl service;

    @PostMapping("/Plan")
    public String savePlan(@Valid @RequestBody Plan plan) {
        return service.savePlan(plan);
    }

    @GetMapping("/Plans")
    public ResponseEntity<Response> getAllPlans() throws PlansNotAddedException {
        {
            HttpStatus httpstatus=null;
            Response response= service.getAllPlans();
            if(!Objects.isNull(response) && !response.getApiStatus().equals(StatusEnum.SUCCESS)) {
                httpstatus=HttpStatus.NOT_FOUND;
            }
            else {
                httpstatus=HttpStatus.OK;
            }
            return new ResponseEntity<>(response,httpstatus);
        }
    }

}
