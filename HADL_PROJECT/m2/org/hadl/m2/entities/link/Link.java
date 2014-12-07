package org.hadl.m2.entities.link;

import org.hadl.m2.entities.component.Configuration;

public abstract class Link {
	
	private String name="";
	private Configuration conf;

	public Link(String name, Configuration conf) {
		this.name =name;
		this.conf = conf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}