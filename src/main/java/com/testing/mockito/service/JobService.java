package com.testing.mockito.service;

import com.testing.mockito.model.JobPosition;
import com.testing.mockito.model.Person;
import java.util.Optional;
import java.util.stream.Stream;

public interface JobService {
  Optional<JobPosition> findCurrentJobPosition(Person person);

  default boolean assignJobPosition(Person person, JobPosition newJobPosition) {
    if (!(findCurrentJobPosition(person).isPresent())) {
      person.setCurrentJobPosition(newJobPosition);
      return true;
    } else {
      return false;
    }
  }

  Stream<JobPosition> listJobs(Person person);
}
