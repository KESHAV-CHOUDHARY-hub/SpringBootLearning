package com.practice.hackathon.service;

import com.practice.hackathon.exception.MobileNumbersNotAddedException;
import com.practice.hackathon.response.Response;

public interface MobileNumberService {

    Response getAllNumbers() throws MobileNumbersNotAddedException;

    String saveAllNumbers();

    String updateAvailabilityOfNumber(int numberId);
}
