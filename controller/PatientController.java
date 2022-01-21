package com.example.project.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.Model.ApplicationUser;
import com.example.project.Model.Patient;
import com.example.project.service.PatientService;

@RestController
@RequestMapping("/patients/")
public class PatientController {
	@Autowired
	PatientService service;
	
	  @PostMapping("/register")
	  public ResponseEntity<String> createTutorial(@RequestBody Patient tutorial) {
	    try {
	      String _tutorial = service.save(tutorial);
	      return new ResponseEntity<>(_tutorial, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @GetMapping("/view/{Id}")
	  public ResponseEntity<Patient> getTutorialById(@PathVariable("Id") String id) {
Patient tutorialData = service.getUserDetails(id);

	    if (tutorialData!=null) {
	      return new ResponseEntity<>(tutorialData, HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	 
	  
	@DeleteMapping("/delete/{Id}")
	  public ResponseEntity<HttpStatus> deleteTutorialById(@PathVariable("Id") String id) {
service.deleteUser(id);

	 
	      return new ResponseEntity<>(HttpStatus.OK);
	    
	  }
		/*
		 * @GetMapping("/tutorials") public ResponseEntity<List<Patient>>
		 * getAllTutorials(@RequestParam(required = false) String title) { try {
		 * List<Patient> tutorials = new ArrayList<Patient>();
		 * 
		 * if (title == null) tutorialRepository.findAll().forEach(tutorials::add); else
		 * tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);
		 * 
		 * if (tutorials.isEmpty()) { return new
		 * ResponseEntity<>(HttpStatus.NO_CONTENT); }
		 * 
		 * return new ResponseEntity<>(tutorials, HttpStatus.OK); } catch (Exception e)
		 * { return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); } }
		 */
	  @GetMapping("/list")
	  public ResponseEntity<List<Patient>> getAllTutorials() {
	    try {
	      List<Patient> tutorials = new ArrayList<Patient>();
	      tutorials=service.getAllUserDetails();
	     
	      if (tutorials.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(tutorials, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}
