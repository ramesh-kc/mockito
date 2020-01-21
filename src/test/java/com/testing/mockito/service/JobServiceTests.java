package com.testing.mockito.service;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.doCallRealMethod;

import com.testing.mockito.model.JobPosition;
import com.testing.mockito.model.Person;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class JobServiceTests {

  @Mock
  private JobService jobService;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void giveDefaultMethod_whenCallRealMethod_thenNoExceptionIsRaised() {
    Person person = new Person();

    Mockito.when(jobService.findCurrentJobPosition(person))
        .thenReturn(Optional.of(new JobPosition()));

    doCallRealMethod()
        .when(jobService)
        .assignJobPosition(Mockito.any(Person.class), Mockito.any(JobPosition.class));

    assertFalse(jobService.assignJobPosition(person, new JobPosition()));
  }
}