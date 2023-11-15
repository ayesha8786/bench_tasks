package com.user.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.user.entity.Booking;
import com.user.entity.Users;
import com.user.repository.UserRepository;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/flights")
	public List<Object> getAllDetails() {
		Object[] flights = restTemplate.getForObject("http://Search/travel/flights", Object[].class);
		return Arrays.asList(flights);
	}

//	@GetMapping("/search")
//	public List<Object> getFlightDetailsByStartStation() {
//		Object[] search = restTemplate.getForObject("http://Search/travel/{departure}/{arrival}", Object[].class);
//		return Arrays.asList(search);
//	}

	@PostMapping("/add")
	public Booking bookByFlightNo(@RequestBody Booking book) {
		restTemplate.postForObject("http://Booking/booking/add", book, Booking.class);
		return book;
	}

	@PutMapping("/updateuser")
	public void updateUser(@RequestBody Users user) {
		userRepository.save(user);
	}

	public void testter() {
		System.out.println("HII");
	}
}
