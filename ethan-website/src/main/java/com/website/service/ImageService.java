package com.website.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.website.domain.Image;
import com.website.dto.ImageRequest;
import com.website.dto.ImageResponse;
import com.website.repository.ImageRepository;

@Component
@Service
public class ImageService {

	@Autowired
	private ImageRepository imageRepository;
	
	public Image create(Image image) {
//		ImageResponse imageRes = new ImageResponse();
//		Image image = new Image();
//		image.setLocation(imageReq.getLocation());
//		image.setName(imageReq.getName());
//		image.setDescription(imageReq.getDescription());
				
		image = imageRepository.save(image);
		
		System.out.println(image);
		
//		//SILLY, why not just return the item fully;
//		imageRes.setLocation(image.getLocation());
//		imageRes.setName(image.getName());
//		imageRes.setDescription(image.getDescription());
//		
		return image;
	}

	public List<Image> findAll() {
		//return (List<ImageResponse>) imageRepository.findAll();
		return imageRepository.findAll();
	}

	public ImageResponse findById(Integer id) {
		//return (ImageResponse) imageRepository.findById(id);
		return null;

	}

	public ImageResponse update(ImageRequest imageRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	public ImageResponse delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Image findOne(String id) {
		return imageRepository.findOne(id);
	}
}
