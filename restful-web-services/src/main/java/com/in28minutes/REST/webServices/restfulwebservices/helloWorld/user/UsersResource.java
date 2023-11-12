package com.in28minutes.REST.webServices.restfulwebservices.helloWorld.user;

import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class UsersResource
{
	
	private UserDaoServices service;
	
	public UsersResource (UserDaoServices service)
	{
		this .service = service;
	}
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers()
	{
		return service.findAll();
	}
	
	//Entity Model
	//web MVC link Builder
	
	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveOneUser(@PathVariable int id)
	{
		
		User user= service.findOneUser(id);
		
		
		EntityModel<User> entityModel=EntityModel.of(user);
		
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		entityModel.add(link.withRel("all-users"));
		
		return entityModel;
	
	}
	
	@PostMapping ("/users")
	public void createUser(@Valid @RequestBody User user)
	{
		service.save(user);
	}
	
	@DeleteMapping ("/users/{id}")
	public void deleteUser(@PathVariable int id)
	{
		service.deleteById(id);
	}
}
