package com.koreait.practice.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class MainClass {

	public static void main(String[] args) {
	// 검색 API
	// 웹, 뉴스, 블로그 등 분야별 네이버 검색 결과를 웹 서비스 또는 모바일 앱에서 보여줄 수 있다.
	//성인 검색어 판별, 한영키 오타 변환 기능을 이용할 수 있다.
	// 웹문서/블로그/뉴스/책/영화/카페글/지식iN/쇼핑/이미지/백과사전/전문자료 분야에 대한 검색 결과
		
		/* 여기서 할 것 */
		// 한/영 키를 잘못 설정하고 검색하셨을 경우, 입력하신 검색어를 자동으로 변환/추천해 주는 REST API입니다.
		
		   String clientId = "_SGCqXrZPI5g0pMyEdOe";//애플리케이션 클라이언트 아이디값";
	       String clientSecret = "4AkripDV3f";//애플리케이션 클라이언트 시크릿값";
	       String text = null;
	        try {
	            text = URLEncoder.encode("그린팩토리", "UTF-8");
	        } catch (UnsupportedEncodingException e) {
	            throw new RuntimeException("검색어 인코딩 실패",e);
	        }
	        
	        String apiURL = "https://openapi.naver.com/v1/search/blog?query=" + text;    // json 결과
	        //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과
	        

	        Map<String, String> requestHeaders = new HashMap<>();
	        requestHeaders.put("X-Naver-Client-Id", clientId);
	        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
	        String responseBody = get(apiURL,requestHeaders);


	        System.out.println(responseBody);
	    }


	    private static String get(String apiUrl, Map<String, String> requestHeaders){
	        HttpURLConnection con = connect(apiUrl);
	        try {
	            con.setRequestMethod("GET");
	            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
	                con.setRequestProperty(header.getKey(), header.getValue());
	            }


	            int responseCode = con.getResponseCode();
	            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
	                return readBody(con.getInputStream());
	            } else { // 에러 발생
	                return readBody(con.getErrorStream());
	            }
	        } catch (IOException e) {
	            throw new RuntimeException("API 요청과 응답 실패", e);
	        } finally {
	            con.disconnect();
	        }
	    }


	    private static HttpURLConnection connect(String apiUrl){
	        try {
	            URL url = new URL(apiUrl);
	            return (HttpURLConnection)url.openConnection();
	        } catch (MalformedURLException e) {
	            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
	        } catch (IOException e) {
	            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
	        }
	    }


	    private static String readBody(InputStream body){
	        InputStreamReader streamReader = new InputStreamReader(body);


	        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
	            StringBuilder responseBody = new StringBuilder();


	            String line;
	            while ((line = lineReader.readLine()) != null) {
	                responseBody.append(line);
	            }


	            return responseBody.toString();
	        } catch (IOException e) {
	            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
	        }
	}

}
