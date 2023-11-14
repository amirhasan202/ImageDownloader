package com.in28minutes.springboot.myfirstapp.todo;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoResource 
{
	private TodoService todoService;
	
	
	public TodoResource(TodoService todoservices)
	{
		this.todoService=todoservices;
	}
	
	@GetMapping("/users/{username}/todos")
	public List<Todo> retrieveTodos(@PathVariable String username)
	{
		return todoService.findByUsername(username);
	}
	
	
	@GetMapping("/users/{username}/todos/{id}")
	public Todo retrieveTodo(@PathVariable String username 
			, @PathVariable int id )
	{
		return todoService.finfById(id);
	}

	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> DeleteTodo(@PathVariable String username 
			, @PathVariable int id )
	{
		todoService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/users/{username}/todos/{id}")
	public Todo updateTodo(@PathVariable String username 
			, @PathVariable int id , @RequestBody Todo todo)
	{
		todoService.updateTodo(todo);
		return todo;
	}
	
	@PostMapping("/users/{username}/todos")
	public Todo createTodo(@PathVariable String username 
			, @RequestBody Todo todo)
	{
		Todo createdTodo = todoService.addtodo1(username , todo.getDescription() 
				, todo.getTargetdate() , todo.isDone() );
		return createdTodo;
	}

	
}
