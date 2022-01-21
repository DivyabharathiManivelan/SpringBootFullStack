
package com.example.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.project.Model.Appointment;
import com.example.project.Model.Patient;
import com.example.project.service.AppointmentService;
import com.example.project.service.PatientService;

@RestController
@RequestMapping("/appointment/")
public class AppointmentController {

	@Autowired
	AppointmentService service;
	
	  @PostMapping("/register")
	  public ResponseEntity<String> createTutorial(@RequestBody Appointment tutorial) {
	    try {
	      String _tutorial = service.save(tutorial);
	      return new ResponseEntity<>(_tutorial, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @GetMapping("/view/{appointmentId}")
	  public ResponseEntity<Appointment> getTutorialBAppointmentyId(@PathVariable("appointmentId") String id) {
		  Appointment tutorialData = service.getUserDetails(id);

	    if (tutorialData!=null) {
	      return new ResponseEntity<>(tutorialData, HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	 
	  @GetMapping("/list/{patientId}")
	  public ResponseEntity<Appointment> getTutorialById(@PathVariable("patientId") String id) {
		  Appointment tutorialData = service.getUserDetails(id);

	    if (tutorialData!=null) {
	      return new ResponseEntity<>(tutorialData, HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	 
	  
	@DeleteMapping("/delete/{appointmentId}")
	  public ResponseEntity<HttpStatus> deleteTutorialById(@PathVariable("appointmentId") String id) {
service.deleteAppointment(id);

	 
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
	  public ResponseEntity<List<Appointment>> getAllTutorials() {
	    try {
	      List<Appointment> tutorials = new ArrayList<Appointment>();
	      tutorials=service.getAllAppointments();
	     
	      if (tutorials.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(tutorials, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
}
