/**
 * 
 */
package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.persistence.Greeting;
import com.example.service.GreetingService;

/**
 * @author apinto
 *
 */
@Controller
@RequestMapping(value="/greeting", produces=MediaType.APPLICATION_JSON_VALUE)
public class GreetingController {
	
	@Autowired
	private GreetingService greetingService;
	
	@RequestMapping(value="/{greetPhrase}")
	@ResponseBody
	public Greeting greet(@PathVariable("greetPhrase") final String greetPhrase) {
		return greetingService.addNewGreeting(greetPhrase);
	}
	
}
