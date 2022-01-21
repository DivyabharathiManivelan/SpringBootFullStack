package com.example.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.project.Model.ApplicationUser;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepository  extends JpaRepository<ApplicationUser, String>{
	 @Query(value="select * from ApplicationUser h where h.user_name = :user_name",nativeQuery=true)
	 ApplicationUser findByUser_name(@Param("user_name")String user_name);
	 
	 @Query(value="select * from ApplicationUser h where h.user_email = :user_email",nativeQuery=true)
	 ApplicationUser findByUser_email(@Param("user_email")String user_email);
}
