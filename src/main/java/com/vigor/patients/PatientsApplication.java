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
public class PatientsApplication {
	@Autowired
	private PatientRepository patientRepository;

	public static void main(String[] args) {
		SpringApplication.run(PatientsApplication.class, args);
	}

	@GetMapping("/patients")
	public Iterable<Patient> index() {
		return patientRepository.findAll();
	}

	@PostMapping("/patients")
	public Iterable<Patient> create (@RequestBody Patient patientData) {
		patientRepository.save(patientData);
		return patientRepository.findAll();
	}

	@DeleteMapping("/patients/{id}")
	public Iterable<Patient> delete(@PathVariable int id) {
		patientRepository.deleteById(id);
		return patientRepository.findAll();
	}

	@PutMapping("/patients/{id}")
	public Iterable<Patient> update(@PathVariable int id, @RequestBody Patient patientData) {
		patientData.setId(id);
		patientRepository.save(patientData);
		return patientRepository.findAll();
	}

}
