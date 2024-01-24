package com.anarghyacomm.hsms.patient.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anarghyacomm.hsms.patient.entity.LoginForm;
import com.anarghyacomm.hsms.patient.entity.PatientEntity;
import com.anarghyacomm.hsms.patient.service.PatientServiceImpl;


@CrossOrigin(origins = "*")
@RestController

public class PatientController {
	
	@Autowired
	private PatientServiceImpl service;
	
	@PostMapping("/addPatient")
	public PatientEntity addPatient(@RequestBody PatientEntity add) {
		return service.addPatent(add);
	}
	
	@GetMapping("/patient/{email}")
	   public PatientEntity getByUserMail(@PathVariable  String email) {
			
		return service.getByEmail(email).get();
		   
	   }
	@GetMapping("/patient/byId/{patientId}")
	public PatientEntity getByPatientId(@PathVariable int patientId) {
		return service.getByPatientId(patientId);
	}
	
	@PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginForm loginForm) {
        Map<String, Object> response = service.login(loginForm);
        return ResponseEntity.ok(response);
    }

}
