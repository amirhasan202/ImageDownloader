package com.in28minutes.REST.webServices.restfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.REST.webServices.restfulwebservices.helloWorld.user.User;

public interface UserRepository extends JpaRepository<User, Integer>
{

}
