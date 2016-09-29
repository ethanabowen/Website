package com.website.endpoint;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.website.dto.ImageRequest;
import com.website.dto.ImageResponse;
import com.website.service.ImageService;

@Component
public class ImageEndpoints {
	
	@Autowired
	public ImageService imageService;
	
	@RequestMapping(value = "/Images/", method = RequestMethod.POST)
    ImageResponse create(@RequestBody @Valid ImageRequest imageRequest) {
        return imageService.create(imageRequest);
    }
 
	//Read
    @RequestMapping(value = "/Images/", method = RequestMethod.GET)
    List<ImageResponse> findAll() {
    	System.out.println("HERE");
        return imageService.findAll();
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
