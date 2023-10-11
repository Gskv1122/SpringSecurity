package com.example.OnesoftSpringSecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {
	@GetMapping(value="/student")
	public String getName() {
		return "this is Student";
	}
	@GetMapping(value="/trainer")
	public String getTrainer() {
		return "this is Trainer";
	}
	@GetMapping(value="/manager")
	public String getManager() {
		return "this is Manager";
	}

}
