package com.testing.mockito.service;

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

class JobPosition {
  private String title;

  public JobPosition() {}

  public JobPosition(String title) {
    super();
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}

class Person {
  private String name;
  private JobPosition currentJobPosition;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public JobPosition getCurrentJobPosition() {
    return currentJobPosition;
  }

  public void setCurrentJobPosition(JobPosition currentJobPosition) {
    this.currentJobPosition = currentJobPosition;
  }
}
