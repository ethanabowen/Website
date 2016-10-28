package com.website.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.website.runkeeper.AuthCallback;

@Component
@Service
public class RunKeeperService {
	
	public static void main(String []args) {
		AuthCallback auth = new AuthCallback();
		auth.stuff("TEST");
	}
}
