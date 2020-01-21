package com.testing.mockito.impl;

import com.testing.mockito.model.JobPosition;
import com.testing.mockito.model.Person;
import com.testing.mockito.service.JobService;
import com.testing.mockito.service.UnemploymentService;
import java.util.Optional;
import java.util.stream.Stream;

public class UnemploymentServiceImpl implements UnemploymentService {

  private JobService jobService;

  public UnemploymentServiceImpl(JobService jobService) {
    this.jobService = jobService;
  }

  @Override
  public boolean personIsEntitledToUnemploymentSupport(Person person) {
    Optional<JobPosition> optional = jobService.findCurrentJobPosition(person);
    return !optional.isPresent();
  }

  @Override
  public Optional<JobPosition> searchJob(Person person, String searchJob) {
    Stream<JobPosition> positionStream = jobService.listJobs(person);
    return positionStream
        .filter(jobPosition -> jobPosition.getTitle().contains(searchJob))
        .findFirst();
  }
}
