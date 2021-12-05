package com.koreait.practice.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;


public class NaverLoginBO {
	
	private final static String CLIENT_ID = "_SGCqXrZPI5g0pMyEdOe";
	private final static String CLIENT_SECRET = "4AkripDV3f";
	private final static String REDIRECT_URI = "http://localhost:9090/practice/login";
	private final static String SESSION_STATE = "oauth_state";
    /* 프로필 조회 API URL */
    private final static String PROFILE_API_URL = "https://openapi.naver.com/v1/nid/me";
    
    public String getAuhorizationUrl(HttpSession session) {
    	String state = generateRandomString();
    	setSession(session,state);
    	
    	OAuth20Service oauthService = new ServiceBuilder()
    			.apiKey(CLIENT_ID)
    			.apiSecret(CLIENT_SECRET)
    			.callback(REDIRECT_URI)
    			.state(state)
    			.build(NaverLoginApi.instance());
    	return oauthService.getAuthorizationUrl();
    	
    }
    
   public OAuth2AccessToken getAccessToken(HttpSession session, String code, String state) throws IOException{
    	// Callback으로 전달받는 세션 검증용 나수값과 세션에 저장되어있는 값이 일치하는지 확인
    	String sessionState = getSession(session);
    	if (StringUtils.pathEquals(sessionState, state)) {
    		OAuth20Service oauthService = new ServiceBuilder()
    				.apiKey(CLIENT_ID)
    				.apiSecret(CLIENT_SECRET)
    				.callback(REDIRECT_URI)
    				.state(state)
    				.build(NaverLoginApi.instance());
    		
    		
    		// scribe에서 제공하는 accesstoken 획득 기능으로 네아로 access token을 획득
    		OAuth2AccessToken accessToken = oauthService.getAccessToken(code);
    		return accessToken;
    	}
    	return null;
    }
    
    
    
    // 세션 유효성 검증 난수 생성기
   private String generateRandomString() {
	   return UUID.randomUUID().toString();
   }
   
   // http session에 데이터 저장
   private void setSession(HttpSession session, String state) {
	   session.setAttribute(SESSION_STATE, state);
   }
   
   // http session에서 데이터 가져오기
   private String getSession(HttpSession session) {
	   return (String)session.getAttribute(SESSION_STATE);
   }
   
   public String getUserProfile(OAuth2AccessToken oauthToken) throws IOException {
	   
	   OAuth20Service oauthService = new ServiceBuilder()
			   .apiKey(CLIENT_ID)
			   .apiSecret(CLIENT_SECRET)
			   .callback(REDIRECT_URI).build(NaverLoginApi.instance());
	   
	   OAuthRequest request = new OAuthRequest(Verb.GET, PROFILE_API_URL, oauthService);
	   oauthService.signRequest(oauthToken, request);
	   Response response = request.send();
	   return response.getBody();
	   
   }
   
}
