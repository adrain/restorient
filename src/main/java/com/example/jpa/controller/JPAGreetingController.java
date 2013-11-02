/**
 * 
 */
package com.example.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.jpa.model.JPAGreeting;
import com.example.jpa.repository.JPAGreetingRepository;
import com.example.util.LogMethodTime;

/**
 * @author apinto
 *
 */
@Controller
@RequestMapping(value="/jpa/greeting", produces=MediaType.APPLICATION_JSON_VALUE)
public class JPAGreetingController {

	@Autowired
	private JPAGreetingRepository repository;
	
	@LogMethodTime
	@RequestMapping(value="/{greetPhrase}")
	@ResponseBody
	public JPAGreeting greet(@PathVariable("greetPhrase") final String greetPhrase) {
		return repository.save(new JPAGreeting(greetPhrase));
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	@LogMethodTime
	public List<JPAGreeting> getAllGreetings() {
		return repository.findAll();
	}
	
}
