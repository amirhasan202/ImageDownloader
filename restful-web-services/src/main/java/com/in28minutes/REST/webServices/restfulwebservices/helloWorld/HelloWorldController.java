package com.in28minutes.REST.webServices.restfulwebservices.helloWorld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//REST API
@RestController
public class HelloWorldController 
{
	
	private MessageSource messageSource;
	
	public HelloWorldController( MessageSource messageSource )
	{
		this.messageSource=messageSource;
	}
	
	// /hello-world
	@GetMapping ( path = "/hello-world")
	public String helloworld()
	{
		return "Hello World";
	}

	@GetMapping ( path = "/hello-world-bean")
	public helloWorldBean helloworldBean()
	{
		return new helloWorldBean("Hello Worllllllllllllllllllllllllllllllllllllld");
	}

	@GetMapping ( path = "/hello-world/path-variable/{name}")
	public helloWorldBean helloworldPathvariable(@PathVariable String name)
	{
		return new helloWorldBean("Hello Worllllllllllllllllllllllllllllllllllllld  "+ name );
	}
	
	@GetMapping ( path = "/hello-world-Internationalized")
	public String helloworldInternationalized()
	{
		 Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale );
//		return "Hello World";
	}

	
}
