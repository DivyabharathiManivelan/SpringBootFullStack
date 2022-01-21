package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.project.Model.Appointment;
import com.example.project.Model.Patient;

import org.springframework.stereotype.Repository;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,String>{
  @Query(value="select * from Appointment h where h.booking_id=:booking_id",nativeQuery=true)
  Appointment findByBooking_id(@Param("booking_id")String booking_id);
	Appointment findByPatientId(String patientId);
}
