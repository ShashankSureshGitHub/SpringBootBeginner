package com.js.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.js.springboot.dto.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

	@Query("Select P from Person p where p.email=:myemail and p.phone=:myphone")
	Person loginPerson(@Param("myemail") String email, @Param("myphone")long phone);
}