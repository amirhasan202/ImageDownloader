package com.in28minutes.REST.webServices.restfulwebservices.versioning;

public class PersionV2 
{
	
	private Name name ;

	public PersionV2(Name name) {
		super();
		this.name = name;
	}

	public Name getName() {
		return name;
	}

	@Override
	public String toString() {
		return "PersionV2 [name=" + name + "]";
	} 
	
	

}
