package org.hadl.m2.lancement;

import java.util.List;

/**
 * 
 * @author arafet&greg
 *
 */
public class Message {

	private String request;
	private List<Object> response;
	
	public Message(String request , List<Object> response) {
		this.request = request;
		this.response = response;
	
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public List<Object> getResponse() {
		return response;
	}

	public void setResponse(List<Object> response) {
		this.response = response;
	}
	
	
}
