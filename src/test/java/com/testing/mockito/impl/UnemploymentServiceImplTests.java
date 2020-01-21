package com.testing.mockito.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import com.testing.mockito.model.Person;
import com.testing.mockito.service.JobService;
import java.util.Optional;
import java.util.stream.Stream;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class UnemploymentServiceImplTests {
  @Mock
  private JobService jobService;

  @InjectMocks
  private UnemploymentServiceImpl unemploymentService;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void givenReturnIsTypeOfOptional_whenMocked_thenValueIsEmpty() {
    Person person = new Person();

    when(jobService.findCurrentJobPosition(Mockito.any(Person.class))).thenReturn(Optional.empty());

    assertTrue(unemploymentService.personIsEntitledToUnemploymentSupport(person));
  }

  @Test
  public void givenReturnIsTypeOfStream_whenDefaultValueIsReturned_thenValueIsEmpty() {
    Person person = new Person();

    when(jobService.listJobs(Mockito.any(Person.class))).thenReturn(Stream.empty());
    assertFalse(unemploymentService.searchJob(person, "").isPresent());
  }
}
