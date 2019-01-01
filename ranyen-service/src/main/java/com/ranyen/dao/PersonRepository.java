package com.ranyen.dao;

import org.springframework.data.repository.CrudRepository;

import com.ranyen.model.Person;

public interface PersonRepository extends CrudRepository <Person, Integer> {

}
