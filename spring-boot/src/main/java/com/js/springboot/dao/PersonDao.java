package com.js.springboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.js.springboot.dto.Person;
import com.js.springboot.repository.PersonRepository;

@Repository
public class PersonDao {

	@Autowired
	PersonRepository personRepository;

	public Person savePerson(Person p) {
		return personRepository.save(p);
	}

	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}

	public Person getPersonById(int id) {
		Optional<Person> optional = personRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public boolean deleteById(int id) {
		Person p = getPersonById(id);
		if (p != null) {
			personRepository.delete(p);
			return true;
		} else {
			return false;
		}
	}

	public Person updateById(int id, Person person) {
		Person p = getPersonById(id);
		if (p != null) {
			return personRepository.save(person);
		} else {
			return null;
		}
	}
	
	public Person loginPerson(String email, long phone)
	{
		return personRepository.loginPerson(email, phone);
	}

}
