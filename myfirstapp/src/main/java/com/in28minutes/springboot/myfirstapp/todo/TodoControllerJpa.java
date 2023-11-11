package com.in28minutes.springboot.myfirstapp.todo;

import java.time.LocalDate;
import java.util.List;

//import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class TodoControllerJpa 
{
	
	private TodoService todoService;
	private TodoRepository todoRepository;
	
	public TodoControllerJpa(TodoService todoService , TodoRepository todoRepository) 
	{
		super();
		this.todoService = todoService;
		this.todoRepository=todoRepository;
	}



	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model)
	{
		
		
		
		String username=(String)model.get("name");
		List<Todo> todos = todoRepository.findByUsername(username);
		
		model.addAttribute("todos",todos);
		
		return "listTodos";
	}
	
	@RequestMapping(value="add-todo" , method = RequestMethod.GET)
	public String ShowNewTodoPage(ModelMap model) 
	{
		
		String username=(String)model.get("name");
		Todo todo = new Todo(0, username , "",LocalDate.now(),false);	
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="add-todo" , method = RequestMethod.POST)
	public String addNewTodo( ModelMap model ,@Valid Todo todo , BindingResult bindingResult) 
	{
		
		
		
		System.out.println(bindingResult);
		if(bindingResult.hasErrors()) 
		{
			
			return "todo";
		}
		
		String username=(String)model.get("name");
		todoService.addtodo(username, todo.getDescription(), todo.getTargetdate(), false);
		return "redirect:list-todos";
	}
	
	
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id)
	{
		todoService.deleteById(id);	
		return "redirect:list-todos";
	}
	
	
	
	@RequestMapping(value="update-todo" , method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id , ModelMap model)
	{
		Todo todo = todoService.finfById(id);
		
		model.addAttribute("todo" , todo);
		return "todo";
	}

	@RequestMapping(value="update-todo" , method = RequestMethod.POST)
	public String updateTodo( ModelMap model ,@Valid Todo todo , BindingResult bindingResult) 
	{
		
		System.out.println(bindingResult);
		if(bindingResult.hasErrors()) 
		{
			
			return "todo";
		}
		
		String username=(String)model.get("name");
		todo.setUsername(username);
		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}

	
	
	
	
	
	
	
	
}
