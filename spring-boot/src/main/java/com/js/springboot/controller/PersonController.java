package com.js.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.js.springboot.dto.Login;
import com.js.springboot.dto.Person;
import com.js.springboot.dto.ResponseStructure;
import com.js.springboot.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	PersonService personService;

	@PostMapping("/persons")
	public ResponseStructure<Person> savePerson(@RequestBody Person p) {
		return personService.savePerson(p);
	}

	@GetMapping("/persons")
	public ResponseStructure<List<Person>> getAllPersons() {
		return personService.getAllPersons();
	}

	@GetMapping("/persons/{id}")
	public ResponseStructure<Person> getPersonById(@PathVariable int id) // to read anything from the url we need
																			// path variable annotation
	{
		return personService.getPersonById(id);
	}

	@DeleteMapping("/persons")
	public String deleteById(@RequestParam int id) {
		return personService.deleteById(id);
	}

	@PutMapping("/persons/{id}")
	public Person updateById(@PathVariable int id, @RequestBody Person person) {
		return personService.updateById(id, person);
	}
	
	@PostMapping("/persons/login")
	public ResponseStructure<String> loginPerson(@RequestBody Login login)
	{
		return personService.loginPerson(login.getEmail(), login.getPhone());
	}
}
