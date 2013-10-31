/**
 * 
 */
package com.example.model.persistence;


/**
 * @author apinto
 *
 */
public class Greeting extends Entity {
	
	private String greetPhrase;
	
	public Greeting() {
	}
	
	public Greeting(final String greetPhrase) {
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
