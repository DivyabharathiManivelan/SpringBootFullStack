/*
 * package com.example.project.service;
 * 
 * import java.util.Arrays; import java.util.Optional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.core.GrantedAuthority; import
 * org.springframework.security.core.authority.SimpleGrantedAuthority; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * import org.springframework.stereotype.Service;
 * 
 * import com.example.project.Model.ApplicationUser; import
 * com.example.project.repository.ApplicationUserRepository;
 * 
 * 
 * 
 * @Service public class UserAuthService {
 * 
 * }
 */


package com.example.project.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.project.Model.ApplicationUser;
import com.example.project.repository.ApplicationUserRepository;



@Service
public class UserAuthService implements UserDetailsService{
	
	/**
	 * 
	 */

	@Autowired
	private ApplicationUserRepository userDao;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
ApplicationUser user = userDao.findByUser_name(username);
		if (user == null) {
			throw new UsernameNotFoundException("User name or passwor is incorrect " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}


}