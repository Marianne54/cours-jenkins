package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String greet() {
		return "Hello, World, c'est bientot l'heure de manger !";
	}

	 public String newGreet() {
		return "Bon appetit !";
	}
}
