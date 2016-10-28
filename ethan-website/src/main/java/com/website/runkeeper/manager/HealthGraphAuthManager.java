package com.website.runkeeper.manager;

import java.net.URI;

import org.apache.catalina.connector.RequestFacade;
import org.apache.commons.logging.Log;
import org.assertj.core.util.Strings;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

import com.website.domain.Run;
import com.website.dto.GetRunRequest;
import com.website.dto.GetRunResponse;

public class HealthGraphAuthManager {
    private static HealthGraphAuthManager instance = new HealthGraphAuthManager();

    //This value is the OAuth 2.0 client ID for your application.
    private static String CLIENT_ID = "4060532d8e9745d3900bcfa37f4b3f83";
    //This value is the OAuth 2.0 shared secret for your application.
    private static String CLIENT_SECRET = "5171f636c51448cca59252ffe49005bc";
    private static String CALLBACK_URI = "healthex://auth";

    private static String AUTH_BASE_URL = "https://runkeeper.com/apps";

    //This is the URL to which your application should redirect the 
    //user in order to authorize access to his or her Runkeeper account
    private static String AUTH_TOKEN_URL = AUTH_BASE_URL + "/authorize";
    
    //This is the URL at which your application can convert an authorization code to an access token.
    private static String ACCESS_TOKEN_URL = AUTH_BASE_URL + "/token";

    private String authCode;
    private String accessToken;

    public static HealthGraphAuthManager getInstance() {
        return instance;
    }

    private HealthGraphAuthManager() {
    }

    public URI getAuthURI() {
        return URI.create((AUTH_TOKEN_URL + "?response_type=code&client_id=" + CLIENT_ID
                + "&redirect_URI=" + CALLBACK_URI));//+ URI.encode(CALLBACK_URI));
    }

    public void processAuthCallback(URI URI) {
        if (URI != null) {
            String code = URI.getRawQuery();//getQueryParameter("code");

            if (code != null && !code.isEmpty() && !code.contains("unauthorized")) {
                authCode = code;
            }
        }
    }

    public void fetchAccessToken() {
        //if (StringUtils.isNotBlank(authCode)) {
    	if(isAuthorized()) {
    		RestTemplate restTemplate = new RestTemplate();
    		GetRunRequest runRequest = new GetRunRequest();
    		//runRequest.addHeader(HttpRequest.HEADER_AUTHORIZATION, "Bearer " + accessToken);
    		/*runRequest.setBody("grant_type=authorization_code"
                            + "&code=" + authCode
                            + "&client_id=" + CLIENT_ID
                            + "&client_secret=" + CLIENT_SECRET
                            + "&redirect_URI=" CALLBACK_URI));*/
    		GetRunResponse runResponse = restTemplate.postForObject(ACCESS_TOKEN_URL, runRequest, GetRunResponse.class);
    		
    		  /*      HttpRequest response = HttpRequest.post(ACCESS_TOKEN_URL)
                    .send("grant_type=authorization_code"
                            + "&code=" + authCode
                            + "&client_id=" + CLIENT_ID
                            + "&client_secret=" + CLIENT_SECRET
                            + "&redirect_URI=" CALLBACK_URI));//+ URI.encode(CALLBACK_URI));*/

            int code = runResponse.getCode();
            String body = runResponse.getBody();
            System.out.println("xxx" + " Response code: " + code + ", body: " + body);

            /** TODO: GSON REPLACEMENT FIX**/
//            if (code == 200) {//OK
//                AccessTokenResponse accessTokenResponse =
//                        new Gson().fromJson(body, AccessTokenResponse.class);
//                accessToken = accessTokenResponse.accessToken;
//            } else {
//                accessToken = null;
//            }

            System.out.println("xxx Got access token: " + accessToken);
        }

    }

	public boolean isAuthorized() {
		return authCode != null && authCode.length() > 1;
	}

//    public RequestInterceptor getRequestInterceptor() {
//        return new RequestInterceptor() {
//            @Override
//            public void intercept(RequestFacade request) {
//                if (Strings.notEmpty(accessToken)) {
//                    Log.d("xxx", "Adding header '" + HttpRequest.HEADER_AUTHORIZATION + ": Bearer " + accessToken + "'");
//                    request.addHeader(HttpRequest.HEADER_AUTHORIZATION, "Bearer " + accessToken);
//                }
//            }
//        };
//    }
//
//    public boolean isAuthorized() {
//        return Strings.notEmpty(authCode);
//    }
//
//    public void setAccessToken(String accessToken) {
//        this.accessToken = accessToken;
//    }
//
//    public String getAccessToken() {
//        return accessToken;
//    }
//
//    private class AccessTokenResponse {
//        @SerializedName("access_token")
//        private String accessToken;
//    }
}
