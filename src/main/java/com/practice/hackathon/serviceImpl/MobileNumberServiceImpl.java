package com.practice.hackathon.serviceImpl;

import com.practice.hackathon.constants.ApplicationConstants;
import com.practice.hackathon.dto.StatusEnum;
import com.practice.hackathon.entity.MobileNumber;
import com.practice.hackathon.exception.MobileNumbersNotAddedException;
import com.practice.hackathon.repository.MobileNumberRepository;
import com.practice.hackathon.response.Response;
import com.practice.hackathon.service.MobileNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MobileNumberServiceImpl implements MobileNumberService {

    @Autowired
    MobileNumberRepository numberRepository;

    @Override
    public Response getAllNumbers() throws MobileNumbersNotAddedException {
        Response response = new Response();
        List<MobileNumber> numbers = new ArrayList<>();
        int check = 0;
        for (MobileNumber numbersIteration : numberRepository.findByAvailability("Y")) {
            if (check>=10) {
                break;
            }
            numbers.add(numbersIteration);
            check = check+1;
        }
        if (numbers.isEmpty()) {
            throw new MobileNumbersNotAddedException("Mobile Numbers Not Added");
        }
        response.setApiStatus(StatusEnum.SUCCESS);
        response.setResponseData(numbers);
        return response;
    }

    @Override
    public String saveAllNumbers() {
        Long number = 9788119400L;
        for (int i = 1; i<100; i++) {
            number = number + i;
            numberRepository.save(new MobileNumber(i, number, ApplicationConstants.NUMBER_AVAILABLE));
        }
        return "Saved 100 Numbers";
    }

    @Override
    public String updateAvailabilityOfNumber(int numberId) {
        MobileNumber number = numberRepository.findById(numberId).get();
        number.setAvailability(ApplicationConstants.NUMBER_NOT_AVAILABLE);
        numberRepository.save(number);
        return "NUMBER OCCUPIED";
    }
}
