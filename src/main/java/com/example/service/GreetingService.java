/**
 * 
 */
package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.persistence.Greeting;
import com.example.persistence.DatabaseManager;
import com.example.persistence.OTransactional;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;
import com.orientechnologies.orient.object.db.OObjectDatabaseTx;

/**
 * @author apinto
 *
 */
@Service
public class GreetingService {
	
	@Autowired
	private DatabaseManager databaseManager;
	
	@OTransactional
	public Greeting addNewGreeting(final String greetPhrase) {
		OObjectDatabaseTx db = databaseManager.getDatabaseTransaction();
		
		Greeting greeting = new Greeting(greetPhrase);
		
		greeting = db.save(greeting);
		
		return greeting;
	}
	
	public List<Greeting> getAllGreetings() {
		OObjectDatabaseTx db = databaseManager.getDatabaseTransaction();
		return db.query(new OSQLSynchQuery<Greeting>("select from Greeting"));
	}

}
