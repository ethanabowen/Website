package com.website.domain;

import org.springframework.data.annotation.Id;

public class Image {

	@Id
	private Integer id;
	
	private String location;
	private String name;
	private String description;
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Image [id=" + id + ", location=" + location + ", name=" + name
				+ ", description=" + description + "]";
	}
	
}
