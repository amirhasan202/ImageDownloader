package com.in28minutes.REST.webServices.restfulwebservices.filtring;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;




@RestController
public class FiltringController 
{
	
	
	
	@GetMapping("/filtring")
	public MappingJacksonValue filtring ( )
	{
		
		SomeBean someBean = new SomeBean("value1", "value2", "");
		
		MappingJacksonValue mappingValue = 
				new MappingJacksonValue(someBean);
		
		
		SimpleBeanPropertyFilter filter = 
				SimpleBeanPropertyFilter.filterOutAllExcept("field2" , "field3");
		
		FilterProvider Filters =
				new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		
		
		mappingValue.setFilters(Filters);
		
		
		return mappingValue;
	}
	
	@GetMapping("/filtring-list")
	public List<SomeBean> filtringList( )
	{
		return Arrays.asList(new SomeBean("value1","value2","Value3") , 
				new SomeBean("value4", "value5", "value6"));
	}

}
