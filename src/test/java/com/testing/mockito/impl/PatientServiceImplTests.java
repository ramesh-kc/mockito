package com.testing.mockito.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class PatientServiceImplTests {
  private PatientServiceImpl patientService;

  @Before
  public void setUp() {
    patientService = Mockito.mock(PatientServiceImpl.class);
  }

  @Test
  public void whenAddCall_thenVerified() {
    Mockito.doNothing().when(patientService).add(isA(Integer.class), isA(Integer.class));
    patientService.add(2, 5);

    verify(patientService, times(1)).add(2, 5);
  }

  @Test
  public void whenAddCall_thenValueCaptured() {
    ArgumentCaptor<Integer> valueArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
    doNothing().when(patientService).add(isA(Integer.class), valueArgumentCaptor.capture());
    patientService.add(2, 5);

    assertEquals(5, (int)valueArgumentCaptor.getValue());
  }

  @Test
  public void whenAddCall_thenRealMethodCalled() {
    doCallRealMethod().when(patientService).add(isA(Integer.class), isA(Integer.class));
    patientService.add(2, 5);

    verify(patientService, times(1)).add(2, 5);
  }
}
