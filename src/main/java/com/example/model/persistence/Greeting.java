/**
 * 
 */
package com.example.model.persistence;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author apinto
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true, value={"handler", "doc", "schemaClass", "document", "owners", "identity"})
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
