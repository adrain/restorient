/**
 * 
 */
package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.persistence.Greeting;
import com.orientechnologies.orient.object.db.OObjectDatabaseTx;

/**
 * @author apinto
 *
 */
@Service
public class GreetingService {
	
	public Greeting addNewGreeting(final String greetPhrase) {
		OObjectDatabaseTx db = new OObjectDatabaseTx("remote:localhost/restorient").open("admin", "admin");
		db.getEntityManager().registerEntityClasses("com.example.model.persistence");
		
		Greeting greeting = new Greeting(greetPhrase);
		
		greeting = db.save(greeting);
		
		db.close();
		
		return greeting;
	}

}
