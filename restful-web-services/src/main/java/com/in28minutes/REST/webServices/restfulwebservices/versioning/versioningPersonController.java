package com.in28minutes.REST.webServices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class versioningPersonController {

	
	@GetMapping(path ="/v1/person")
	public PersionV1 getFirstVersionOfPerson()
	{
		return new PersionV1("Bob Chrlie");
	}
	
	@GetMapping(path ="/v2/person")
	public PersionV2 getSecondVersionOfPerson()
	{
		return new PersionV2(new Name("Bob "," Chrlie"));
	}

	@GetMapping(path ="/person" , params = "version=1")
	public PersionV1 getFirstVersionOfPersonRequestParameter()
	{
		
		return new PersionV1("Bob Chrlie");
	}

	@GetMapping(path ="/person" , params = "version=2")
	public PersionV2 getSecondVersionOfPersonRequestParameter()
	{
		
		return new PersionV2(new Name("Bob "," Chrlie"));
	}
	
	@GetMapping(path ="/person/header" , headers="X-API-VERSION=1")
	public PersionV1 getFirstVersionOfPersonRequestHeaders()
	{
		
		return new PersionV1("Bob Chrlie");
	}
	
	@GetMapping(path ="/person/header" , headers="X-API-VERSION=2")
	public PersionV2 getSecondVersionOfPersonRequestHeaders()
	{
		
		return new PersionV2(new Name("Bob "," Chrlie"));
	}
	
	@GetMapping(path ="/person/accept" , produces = "application/vnd.company.app-v1+json")
	public PersionV1 getFirstVersionOfPersonAcceptHeaders()
	{
		
		return new PersionV1("Bob Chrlie");
	}
	
	@GetMapping(path ="/person/accept" , produces = "application/vnd.company.app-v2+json")
	public PersionV2 getSecondVersionOfPersonAcceptHeaders()
	{
		
		return new PersionV2(new Name("Bob "," Chrlie"));
	}



}
