/*
 * package com.example.project.service;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpHeaders; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.security.authentication.AuthenticationManager; import
 * org.springframework.security.authentication.
 * UsernamePasswordAuthenticationToken; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.stereotype.Service; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.json.simple.JSONObject;
 * 
 * import com.example.project.Model.ApplicationUser; import
 * com.example.project.repository.ApplicationUserRepository; import
 * com.example.project.security.JwtUtil;
 * 
 * 
 * 
 * @Service public class ApplicationUserService {
 * 
 * }
 * 
 */
package com.example.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.json.simple.JSONObject;

import com.example.project.Model.ApplicationUser;
import com.example.project.repository.ApplicationUserRepository;
import com.example.project.security.JwtUtil;



@Service
public class ApplicationUserService {
@Autowired
	JwtUtil jwtTokenUtil;
@Autowired
ApplicationUserRepository repo;
@Autowired
UserAuthService userService;
@Autowired
	private AuthenticationManager authenticationManager;
public String save(ApplicationUser user){
   BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String encodedPassword = passwordEncoder.encode(user.getPassword());
    user.setPassword(encodedPassword);
    ApplicationUser user3=null;
    try {
    	user3=repo.findByUser_email(user.getUser_email());
    	
    }
    catch(Exception e)
    {
    	
    }
    ApplicationUser user2=null;
    JSONObject person = new JSONObject();
    if(user3==null) {
    user2=repo.save(user);
    if(user2!=null){
        person.put("message", "Registration successful");
    }
    else{
   person.put("message", "Password or username policy failed");
    }
    }
    else {
    	person.put("message", "Password or username policy failed");
    }
  
 
  
   String personstr=person.toString();
  return personstr;
}

public ApplicationUser getUserDetails(String username) {
	return repo.findByUser_name(username);
}

public ApplicationUser updateUserDetails(ApplicationUser user) {
	return repo.save(user);
}


public String authenticate(ApplicationUser user) throws Exception {
  String res="";
  try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(),null));
    res="success";
    

		 UserDetails userDetails = userService.loadUserByUsername(user.getUsername());
		
		

		 String token = jwtTokenUtil.generateToken(userDetails);

		 JSONObject person = new JSONObject();
		 person.put("message","Authentication successful!");
		 person.put("token",token);
		 person.put("id",userDetails.getUsername());
		String personstr=person.toString();
		res=personstr;
		
    } catch (Exception e) {
    	e.printStackTrace();
    	JSONObject person = new JSONObject();
		 person.put("message","Username or Password is Incorrect.");
		String personstr=person.toString();
		res=personstr;
    } 
    return res;
	}

}

