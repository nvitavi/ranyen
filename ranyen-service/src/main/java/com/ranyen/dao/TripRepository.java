package com.ranyen.dao;

import org.springframework.data.repository.CrudRepository;

import com.ranyen.model.Trip;

public interface TripRepository extends CrudRepository <Trip, Integer> {

}
