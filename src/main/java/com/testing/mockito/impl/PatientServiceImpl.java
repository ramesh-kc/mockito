package com.testing.mockito.impl;

import com.testing.mockito.service.PatientService;

public class PatientServiceImpl implements PatientService {

  @Override
  public void add(int firstNumber, int secondNumber) {
    System.out.println("The Sum is: " + firstNumber + secondNumber);
  }
}
