package com.anarghyacomm.hsms.patient.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anarghyacomm.hsms.patient.entity.LoginForm;
import com.anarghyacomm.hsms.patient.entity.PatientEntity;
import com.anarghyacomm.hsms.patient.repo.PatientRepository;




@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
     private PatientRepository repo;
	
	public PatientEntity addPatent(PatientEntity add) {
		Random random = new Random();
		int randomPatientId = 100000 + random.nextInt(900000);  // Generates a random number between 100000 and 999999
		add.setPatientId(randomPatientId);
		return repo.save(add);
		
	}
	
	 public Optional<PatientEntity> getByEmail(String email) {
		 return repo.findByEmail(email);
	 }
	 
	 public PatientEntity getByPatientId(int patientId) {
		 Optional<PatientEntity> findByPatientId = repo.findByPatientId(patientId);
		 if(findByPatientId.isEmpty()) {
			 return null;
		 }
		 return findByPatientId.get();
	 }
	 
	
//		public String login(LoginForm loginForm)  {
//			Optional<PatientEntity>  byUserEmail = repo.findByEmail(loginForm.getEmail());
//			  if( byUserEmail.isPresent()) {
//				  if(byUserEmail.get().getPhoneNumber().equalsIgnoreCase(loginForm.getPhoneNumber())) {
//					  return "Login success";
//				  }
//			  }
//			
//			return "Login failed";
//			
//					}
	 
	 public Map<String, Object> login(LoginForm loginForm) {
	        Map<String, Object> response = new HashMap<>();

	        Optional<PatientEntity> byUserEmail = repo.findByEmail(loginForm.getEmail());

	        if (byUserEmail.isPresent()) {
	            if (byUserEmail.get().getPhoneNumber().equalsIgnoreCase(loginForm.getPhoneNumber())) {
	                response.put("status", "Login success");
	                response.put("user", byUserEmail.get()); // Add the user object to the response
	                return response;
	            }
	        }

	        response.put("status", "Login failed");
	        return response;
	    }
	 
		
		

}
