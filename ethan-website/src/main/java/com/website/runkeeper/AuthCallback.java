package com.website.runkeeper;

import java.net.URI;

import com.website.runkeeper.manager.HealthGraphAuthManager;

public class AuthCallback{

    public void stuff(String uri) {
    	try{
	        URI baseUri = new URI(uri);
	        HealthGraphAuthManager.getInstance()
	                .processAuthCallback(baseUri);
	
	        if (!HealthGraphAuthManager.getInstance().isAuthorized()) {
	            System.out.println("Authorization Failed");
	        } else {
	        	try{
	                HealthGraphAuthManager.getInstance().fetchAccessToken();
	        	} catch(Exception e) {
	        		e.printStackTrace();
	        	} finally {
	        		System.out.println("Token received");
	        	}
	        }
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}