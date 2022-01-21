package com.example.project.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import com.example.project.Model.ApplicationUser;
import com.example.project.service.ApplicationUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import com.example.project.service.UserAuthService;
import com.example.project.security.JwtUtil;
@RestController
public class ApplicationUserController {
 @Autowired
  ApplicationUserService userDetailsService;
	@Autowired
	private UserAuthService userDetailsService1;
	@Autowired
	private JwtUtil jwtTokenUtil;
	
@PostMapping("/register")
	public ResponseEntity<String> saveUser(@RequestBody ApplicationUser user) throws Exception {
	return new ResponseEntity(userDetailsService.save(user),HttpStatus.OK);
  }
  

	@PostMapping(value = "/signin")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody ApplicationUser user) throws Exception {

		String res=userDetailsService.authenticate(user);
		return new ResponseEntity(res,HttpStatus.OK);
	}
	
	  @GetMapping("/viewprofile/{userId}")
	  public ResponseEntity<ApplicationUser> getTutorialById(@PathVariable("userId") String id) {
ApplicationUser tutorialData = userDetailsService.getUserDetails(id);

	    if (tutorialData!=null) {
	      return new ResponseEntity<>(tutorialData, HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  @PutMapping("/editprofile/{userId}")
	  public ResponseEntity<ApplicationUser> updateTutorial(@PathVariable("userId") String id, @RequestBody ApplicationUser tutorial) {
	    ApplicationUser tutorialData = userDetailsService.getUserDetails(id);

	    if (tutorialData!=null) {
	      ApplicationUser _tutorial = tutorialData;
	      _tutorial.setLocation(tutorial.getLocation());
	      _tutorial.setUser_email(tutorial.getUser_email());
	      _tutorial.setUser_mobile(tutorial.getUser_mobile());
	      return new ResponseEntity<>(userDetailsService.updateUserDetails(_tutorial), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	
}
