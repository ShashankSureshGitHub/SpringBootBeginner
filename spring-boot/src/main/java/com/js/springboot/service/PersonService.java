package com.js.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.js.springboot.dao.PersonDao;
import com.js.springboot.dto.Person;
import com.js.springboot.dto.ResponseStructure;

@Service
public class PersonService {

	@Autowired
	PersonDao personDao;

	public ResponseStructure<Person> savePerson(Person p) {

		Person person=personDao.savePerson(p);
		ResponseStructure<Person> responseStructure=new ResponseStructure<>();
		if(person!=null)
		{
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Saved Data Successfully");
		responseStructure.setData(person);
		return responseStructure;
		}
		else
		{
			responseStructure.setStatusCode(HttpStatus.NO_CONTENT.value());
			responseStructure.setMessage("Data Failed to save");
			responseStructure.setData(person);
			return responseStructure;
		}
		
	}
	
	public ResponseStructure<List<Person>> getAllPersons(){
		
		ResponseStructure<List<Person>> responseStructure=new ResponseStructure<>();
		List<Person> persons=personDao.getAllPersons();
		if(persons.size()>0)
		{
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("All Persons Found");
			responseStructure.setData(persons);
			return responseStructure;
		}
		else
		{
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("no persons");
			responseStructure.setData(persons);
			return responseStructure;
		}
	}
	
	public ResponseStructure<Person> getPersonById(int id) {
		Person person=personDao.getPersonById(id);
		ResponseStructure<Person> responseStructure=new ResponseStructure<>();
		if(person!=null)
		{
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Found the person");
		responseStructure.setData(person);
		return responseStructure;
		}
		else
		{
			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("No person Found");
			responseStructure.setData(person);
			return responseStructure;
		}
		
	}
	public String deleteById(int id)
	{
		if(personDao.deleteById(id))
		{
			return "Deleted Successfully";
		}
		else
		{
			return "No Person with given Id";
		}
	}
	public Person updateById(int id, Person person)
	{
	 return personDao.updateById(id, person);
	}
	

	public ResponseStructure<String> loginPerson(String email, long phone)
	{
		ResponseStructure< String> responseStructure=new ResponseStructure<>();
		Person p=personDao.loginPerson(email, phone);
		if(p!=null)
		{
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMessage("LOgin successful");
			responseStructure.setData("done");
			return responseStructure;
		}
		else
		{
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setMessage("Login failed");
			responseStructure.setData("failed");
			return responseStructure;
		}
	}
}
	
	
	
