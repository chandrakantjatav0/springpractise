package com.WebseriesController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Netflix {
	
	@GetMapping(path = "/netflix")
	public String movie() {
		return "All of us are Dead";
	}
}
