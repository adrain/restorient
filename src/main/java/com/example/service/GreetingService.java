/**
 * 
 */
package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.persistence.Greeting;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;
import com.orientechnologies.orient.object.db.OObjectDatabaseTx;

/**
 * @author apinto
 *
 */
@Service
public class GreetingService {
	
	private OObjectDatabaseTx getDatabase() {
		OObjectDatabaseTx db = new OObjectDatabaseTx("remote:localhost/restorient").open("admin", "admin");
		db.getEntityManager().registerEntityClasses("com.example.model.persistence");
		return db;
	}
	
	public Greeting addNewGreeting(final String greetPhrase) {
		OObjectDatabaseTx db = getDatabase();
		
		Greeting greeting = new Greeting(greetPhrase);
		
		greeting = db.save(greeting);
		
		db.close();
		
		return greeting;
	}
	
	public List<Greeting> getAllGreetings() {
		OObjectDatabaseTx db = getDatabase();
		return db.query(new OSQLSynchQuery<Greeting>("select from Greeting"));
	}

}
