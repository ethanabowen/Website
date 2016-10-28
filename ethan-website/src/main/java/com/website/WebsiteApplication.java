package com.website;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan("com.website")
public class WebsiteApplication {

	public static void main(String[] args) {
        new SpringApplicationBuilder()
    	.sources(WebsiteApplication.class)
    	.profiles("local")
    	.run(args);
	}
	
	@RestController
	class GreetingController {
	    
	    @RequestMapping("/hello/{name}")
	    String hello(@PathVariable String name) {
	        return "Hello, " + name + "!";
	    }
	}	    
}
