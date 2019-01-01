package com.ranyen.dao;

import org.springframework.data.repository.CrudRepository;

import com.ranyen.model.Picture;

public interface PictureRepository extends CrudRepository <Picture, Integer> {

}
