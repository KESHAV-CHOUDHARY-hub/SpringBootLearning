package com.practice.hackathon.service;

import com.practice.hackathon.entity.Plan;
import com.practice.hackathon.exception.PlansNotAddedException;
import com.practice.hackathon.response.Response;

public interface PlansService {
    String savePlan(Plan plan);

    Response getAllPlans() throws PlansNotAddedException;
}
