package com.example.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.data.jpa.domain.AbstractPersistable;


@Entity
public class JPAGreeting extends AbstractPersistable<Long> {
	
	private static final long serialVersionUID = -1685410512447839966L;
	
	@Column
	private String greetPhrase;
	
	public JPAGreeting() {
	}
	
	public JPAGreeting(final String greetPhrase) {
		this.greetPhrase = greetPhrase;
	}
	
	/**
	 * @return the greetPhrase
	 */
	public String getGreetPhrase() {
		return greetPhrase;
	}

	/**
	 * @param greetPhrase the greetPhrase to set
	 */
	public void setGreetPhrase(String greetPhrase) {
		this.greetPhrase = greetPhrase;
	}
	
}
