package com.website.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.website.domain.Image;

@Component
@Repository
public interface ImageRepository extends MongoRepository<Image, String> {

	//Image create(Image imageReq);

//	List<Image> findByLastName(@Param("name") String name);
//    List<Image> findAll();
//    Image findById(@Param("id") Integer id);
//
//    Image update(Image imageReq);
//	void delete(Image deleted);

	
}