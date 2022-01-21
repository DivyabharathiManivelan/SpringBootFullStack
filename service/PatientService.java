package com.example.project.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.project.Model.ApplicationUser;
import com.example.project.Model.Patient;
import com.example.project.repository.ApplicationUserRepository;
import com.example.project.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository userDao;

	Patient user;

	public String save(Patient user){
		   
		    Patient user2=userDao.save(user);
		 
		   JSONObject person = new JSONObject();
		 try {
		   if(user2!=null){
		      person.put("message", "Registration successful");
		  }
		  else{
		 person.put("message", "Registration Failure");
		  }
		 }
		 catch(Exception e) {
			 person.put("message", "Registration Failure");
		 }
		   String personstr=person.toString();
		  return personstr;
		}
	
	public Patient getUserDetails(String patientId) {
		Patient p=userDao.findByPatient_Id(patientId);
		return p;
	}
	public void deleteUser(String patientId) {
		userDao.deleteById(patientId);
	}
	public List<Patient> getAllUserDetails(){
		  List<Patient> tutorials = new ArrayList<Patient>();
		
		  	        userDao.findAll().forEach(tutorials::add);
		  	        return tutorials;
	}
}
