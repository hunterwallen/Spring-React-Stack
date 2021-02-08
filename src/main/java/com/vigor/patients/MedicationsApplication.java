package com.vigor.patients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
@RestController
public class MedicationsApplication {
	@Autowired
	private MedicationRepository medicationRepository;

	public static void main(String[] args) {
		SpringApplication.run(MedicationsApplication.class, args);
	}

	@GetMapping("/medications")
	public Iterable<Medication> index() {
		return medicationRepository.findAll();
	}

	@GetMapping("/medications/{patientId}")
	public Iterable<Medication> findBypatientId(@PathVariable String patientId) {
		return medicationRepository.findBypatientId(patientId);
	}

	@PostMapping("/medications")
	public Iterable<Medication> create (@RequestBody Medication medicationData) {
		medicationRepository.save(medicationData);
		return medicationRepository.findAll();
	}

	@DeleteMapping("/medications/{id}")
	public Iterable<Medication> delete(@PathVariable int id) {
		medicationRepository.deleteById(id);
		return medicationRepository.findAll();
	}

	@PutMapping("/medications/{id}")
	public Iterable<Medication> update(@PathVariable int id, @RequestBody Medication medicationData) {
		medicationData.setId(id);
		medicationRepository.save(medicationData);
		return medicationRepository.findAll();
	}

}
