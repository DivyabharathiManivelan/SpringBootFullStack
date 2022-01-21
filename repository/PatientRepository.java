package com.example.project.repository;

import org.springframework.stereotype.Repository;

import com.example.project.Model.ApplicationUser;
import com.example.project.Model.Patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface PatientRepository extends JpaRepository<Patient,String>{
  @Query(value="select * from Patient h where h.patient_Id=:patient_Id",nativeQuery=true)
  Patient findByPatient_Id(@Param("patient_Id")String patient_Id);

}
