package com.practice.hackathon.serviceImpl;

import com.practice.hackathon.dto.StatusEnum;
import com.practice.hackathon.entity.Plan;
import com.practice.hackathon.exception.PlansNotAddedException;
import com.practice.hackathon.repository.PlansRepository;
import com.practice.hackathon.response.Response;
import com.practice.hackathon.service.PlansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlansServiceImpl implements PlansService {

    @Autowired
    PlansRepository repository;

    @Override
    public String savePlan(Plan plan) {
         repository.save(plan);
         return "PLAN SAVED";
    }

    @Override
    public Response getAllPlans() throws PlansNotAddedException {
        Response response = new Response();
        List<Plan> plansList = repository.findAll();
        if (plansList.isEmpty()) {
            throw new PlansNotAddedException("No Plans Detected");
        }
        response.setApiStatus(StatusEnum.SUCCESS);
        response.setResponseData(plansList);
        return response;
    }
}
