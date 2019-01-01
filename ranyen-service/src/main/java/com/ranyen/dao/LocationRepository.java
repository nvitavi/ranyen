package com.ranyen.dao;

import org.springframework.data.repository.CrudRepository;

import com.ranyen.model.Location;

public interface LocationRepository extends CrudRepository <Location, Integer>  {

}
