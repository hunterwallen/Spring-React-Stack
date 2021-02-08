package com.vigor.patients;

import org.springframework.data.repository.CrudRepository;

public interface MedicationRepository extends CrudRepository<Medication, Integer> {
  Iterable<Medication> findBypatientId(String patientId);
}
