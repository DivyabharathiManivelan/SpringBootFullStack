package com.example.project.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.Model.Appointment;
import com.example.project.Model.Patient;
import com.example.project.repository.AppointmentRepository;
import com.example.project.repository.PatientRepository;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository userDao;

	Patient user;

	public String save(Appointment user){
		   
		    Appointment user2=userDao.save(user);
		 
		   JSONObject person = new JSONObject();
		 
		   if(user2!=null){
		      person.put("message", "Booking successful");
		  }
		  else{
		 person.put("message", "Booking Failure");
		  }
		   String personstr=person.toString();
		  return personstr;
		}
	
	public Appointment getUserDetailsByBookingId(String bookingId) {
		Appointment p=userDao.findByBooking_id(bookingId);
		return p;
	}
	public Appointment getUserDetails(String patientId) {
		Appointment p=userDao.findByPatientId(patientId);
		return p;
	}
    public void deleteAppointment(String appintId) {
    	 try {
    		 userDao.deleteById(appintId);
    	    } catch (Exception e) {
    	    }
    }

    public List<Appointment> getAllAppointments() {
    	
    	  List<Appointment> tutorials = new ArrayList<Appointment>();
  		
	        userDao.findAll().forEach(tutorials::add);
	        return tutorials;
    	
    }
}
