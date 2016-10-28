package com.website.endpoint;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.website.domain.Image;
import com.website.dto.ImageRequest;
import com.website.dto.ImageResponse;
import com.website.service.ImageService;

@Component
@RestController
public class RunKeeperEndpoints {
	
	@Autowired
	public ImageService imageService;
	
	@RequestMapping(value = "/Images/", method = RequestMethod.POST)
    Image create(@RequestBody @Valid Image imageRequest) {
        return imageService.create(imageRequest);
    }
 
	//Read
    @RequestMapping(value = "/Images/", method = RequestMethod.GET)
    List<Image> findAll() {
    	System.out.println("HERE");
        return imageService.findAll();
    }
    
    @RequestMapping(value = "/Images/Find", method = RequestMethod.GET)
    Image findOne(@RequestParam(value = "id") String id)  {
    	System.out.println("here find");
        return imageService.findOne(id);
    }
    
    @RequestMapping(value = "/Images/{id}", method = RequestMethod.GET)
    ImageResponse findById(@PathVariable("id") Integer id) {
        return imageService.findById(id);
    }
    
    @RequestMapping(value = "/Images/{id}", method = RequestMethod.PUT)
    ImageResponse update(@RequestBody @Valid ImageRequest imageRequest) {
        return imageService.update(imageRequest);
    }
    
    @RequestMapping(value = "/Images/{id}/Delete", method = RequestMethod.POST)
    ImageResponse delete(@PathVariable("id") Integer id) {
	        return imageService.delete(id);
    }	 
}
