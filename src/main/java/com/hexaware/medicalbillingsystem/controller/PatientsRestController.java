package com.hexaware.medicalbillingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.medicalbillingsystem.dto.PatientsDTO;
import com.hexaware.medicalbillingsystem.entities.Patients;
import com.hexaware.medicalbillingsystem.exceptions.PatientNotFoundException;
import com.hexaware.medicalbillingsystem.service.IPatientsService;

@RestController
@RequestMapping("/api/patients")
public class PatientsRestController {

	@Autowired
	IPatientsService service;

	@GetMapping("/welcome")
	public String newPatient() {
		return "Hello New Patient";
	}

	@PostMapping("/add/new")
	public Patients insertPatients(@RequestBody PatientsDTO patientDTO) {

		return service.addPatients(patientDTO);
	}

	@PutMapping("/update/patient")
	public Patients updatePatient(@RequestBody PatientsDTO patientDTO) {
		return service.updatepatients(patientDTO);

	}

	@DeleteMapping("/delete/patient/{patientId}")
	public String deletePatients(@PathVariable int patientId) {

		service.deletePatients(patientId);
		return "Successfully Delete patient with id: " + patientId;
	}

	@GetMapping("/getbyname/{patientName}")
	public PatientsDTO getByPatientName(@PathVariable String patientName) {
		PatientsDTO patientdto = service.getPatientByName(patientName);
		if (patientdto.getPatientName() == null) {
			throw new PatientNotFoundException(HttpStatus.NOT_FOUND,
					"Patient with name " + patientName + " does not exist");
		}
		return patientdto;
	}

	@GetMapping("/get/allPatients")
	public List<Patients> getAllPatients() {
		return service.getAllPatients();
	}
}
