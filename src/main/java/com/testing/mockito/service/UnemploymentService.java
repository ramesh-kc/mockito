package com.testing.mockito.service;

import com.testing.mockito.model.JobPosition;
import com.testing.mockito.model.Person;
import java.util.Optional;

public interface UnemploymentService {

  boolean personIsEntitledToUnemploymentSupport(Person person);

  Optional<JobPosition> searchJob(Person person, String searchJob);
}
