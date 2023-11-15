
package com.user.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.entity.AuthenticationRequest;
import com.user.entity.Users;
import com.user.repository.UserRepository;
import com.user.security.JwtUtils;
import com.user.service.SecurityService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SecurityService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtils jwtUtils;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@GetMapping("/token")

	public String testingToken()
	{
		return "<h1>Welcome to Dashboard<h1>"; 
	}
	
	@PostMapping("/subs")
	
	public ResponseEntity<?> subscribeClient(@RequestBody AuthenticationRequest authenticationRequest)
	{
		String username=authenticationRequest.getUsername();
		String password=authenticationRequest.getPassword();
		String email=authenticationRequest.getEmail();
		
		Users user=new Users();
		user.setUsername(username);
		//customer.setPassword(password);
		 user.setPassword(passwordEncoder.encode(authenticationRequest.getPassword()));
		 user.setEmail(email);
		 
		try {
			userRepository.save(user);
			}
		catch(Exception e)
		{
			return ResponseEntity.ok("Error during subscription");	
		}
		
		return ResponseEntity.ok("Successfully subcribed "+username);
	}
	 
	@PostMapping("/auth")
	
	public ResponseEntity<?> authenticateClient(@RequestBody AuthenticationRequest authenticationRequest)
	{
		

		String username=authenticationRequest.getUsername();
		String password=authenticationRequest.getPassword();
		
		try
		{
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
		}
		catch(Exception e)
		{
		return ResponseEntity.ok("Error during authentication");
		}
		
		UserDetails loadedUser=userService.loadUserByUsername(username);
		
		String generatedToken=jwtUtils.generateToken(loadedUser);

		return ResponseEntity.ok(generatedToken );
		//return ResponseEntity.ok(new AuthenticationResponse("Successfully subcribed "+username));
	
}
}