package com.example.persistence;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.orientechnologies.orient.object.db.OObjectDatabaseTx;

/**
 * 
 * @author apinto
 *
 */
@Component
@Aspect
public class DatabaseManager {
	
	@SuppressWarnings("unused")
	private String databaseConnectionURL;
	
	@SuppressWarnings("unused")
	private String persistenceModelPackage;
	
	@SuppressWarnings("unused")
	private String username;
	
	@SuppressWarnings("unused")
	private String password;
	
	private OObjectDatabaseTx objectDatabaseTx;
	
	public DatabaseManager() {
		this("remote:localhost/restorient", "admin", "admin", "com.example.model.persistence");
	}

	public DatabaseManager(final String databaseConnectionURL, final String username, final String password, String persistenceModelPackage) {
		
		this.databaseConnectionURL = databaseConnectionURL;
		this.persistenceModelPackage = persistenceModelPackage;
		this.username = username;
		this.password = password;
		
		this.objectDatabaseTx = new OObjectDatabaseTx(databaseConnectionURL).open(username, password);
		this.objectDatabaseTx.getEntityManager().registerEntityClasses(persistenceModelPackage);
		
	}
	
	public OObjectDatabaseTx getDatabaseTransaction() {
		return this.objectDatabaseTx;
	}
	
	@Around("@annotation(com.example.persistence.OTransactional)")
	public Object logMethodExectutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("@@@"+joinPoint.getThis());
		getDatabaseTransaction().begin();
		
		Object retVal = joinPoint.proceed();
		
		getDatabaseTransaction().commit();
		
		return retVal;
	}
	
}
