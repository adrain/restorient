/**
 * 
 */
package com.example.model.persistence;

import javax.persistence.Id;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author apinto
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true, value={"handler", "doc", "schemaClass", "document", "owners", "identity"})
public abstract class Entity {
	
	@JsonIgnore
	@Id
	private Object id;
	
	@JsonIgnore
	@Version
	private Object version;

	/**
	 * @return the id
	 */
	@JsonProperty
	public String getId() {
		return id.toString();
	}
	
}
