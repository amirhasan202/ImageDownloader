package com.in28minutes.REST.webServices.restfulwebservices.versioning;


public class PersionV1 
{

	private String name;
	
	public PersionV1(String name)
	{
		super();
		this.name=name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "PersionV1 [name=" + name + "]";
	}
	
	

}
