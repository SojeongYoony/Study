package com.koreait.integration.batch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class BookJob implements Job {
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		// 저자 "황순원", "생텍쥐베리" 중 임의로 한 명의 정보를 이용하여 도서를 검색한 결과를 출력하시오.
		// (도서 정보의 파일을 생성하시오)
		try {
	         String apiURL = "http://localhost:9090/integration/book/findAllBook";
	         URL url = new URL(apiURL);
	         HttpURLConnection con = (HttpURLConnection)url.openConnection();
	            System.out.println("con11: "+con);   //ok
	         
	         BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	         StringBuilder sb = new StringBuilder();
	         String line = "";
	         while( (line = br.readLine()) != null ) {
	            sb.append(line);
	         }
	         br.close();

	         JSONObject obj = new JSONObject(sb.toString());
	         JSONArray arr = obj.getJSONArray("list");
	         List<String> list = new ArrayList<>();
	         
	         for( int i=0; i<arr.length(); i++) {
	                                                      // arr[i]=JSONObject이다.          제이슨오브젝트안에 list가 있고 list는 제이슨오브젝트이기 때문에 한번 더 꺼내서 확인해야한다. list가 배열이기 때문에 for문 돌려야 확인 가능
	            JSONObject o =   arr.getJSONObject(i);    // getJSONObject()은 제이슨 객체를 꺼낼수있다.     o에는 각 list 존재함 
	            list.add(o.getString("author"));
	         }
	         
	         System.out.println(list.toString());  // 저자들 값 저장 완료
	         int n = (int)(Math.random()*list.size());
	      
	         JSONArray arr2 = obj.getJSONArray("list");
	      
	            // arr2[i]=JSONObject이다.          제이슨오브젝트안에 list가 있고 list는 제이슨오브젝트이기 때문에 한번 더 꺼내서 확인해야한다. list가 배열이기 때문에 for문 돌려야 확인 가능
	         JSONObject o =   arr2.getJSONObject(n);    // getJSONObject()은 제이슨 객체를 꺼낼수있다.
	         File file = new File("author_info"+ o.getString("author") +".txt");
	         BufferedWriter bw = new BufferedWriter(new FileWriter(file));
	         bw.write("번호 : " + o.getInt("no") + "\n");
	         bw.write("제목 : " + o.getString("title") + "\n");
	         bw.write("개요 : " + o.getString("preview") + "\n");
	         bw.write("저자 : " + o.getString("author") + "\n");
	         bw.write("가격 : " + o.getInt("price"));
	         bw.close();
	         ///////////////////////////////////////////////////////////////////////
	         File file2 = new File(o.getString("author") + "_author_info.txt"); // 새로운 사실. 파일명에 공백이 있으면 안됨.
	         BufferedWriter bw2 = new BufferedWriter(new FileWriter(file2));
	         bw2.write("번호 : " + o.getInt("no") + "\n");
	         bw2.write("제목 : " + o.getString("title") + "\n");
	         bw2.write("개요 : " + o.getString("preview") + "\n");
	         bw2.write("저자 : " + o.getString("author") + "\n");
	         bw2.write("가격 : " + o.getInt("price"));
	         bw2.close();
	         
		
		
//		try {
//			BookRepository repository = sqlSession.getMapper(BookRepository.class);
//			List<Book> list = new ArrayList<Book>();
//			list = repository.findAuthor();
//			System.out.println(list);
//			
//			int idx = (int)(Math.random() * list.size() );
//			
//			String apiURL = "http://localhost:9090/integration/book/findBook?column=author&query=" + URLEncoder.encode(list.get(idx), "UTF-8");
//			URL url = new URL(apiURL);
//			HttpURLConnection con = (HttpURLConnection)url.openConnection();
//			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
//			StringBuilder sb = new StringBuilder();
//			String line = "";
//			while ( (line = br.readLine()) != null ) { // 한 줄씩 읽으시오.
//				sb.append(line);
//			}
//			JSONObject obj = new JSONObject(sb.toString()); // json 객체의 data
//			JSONArray arr = obj.getJSONArray("list");
//			for ( int i = 0; i < arr.length(); i++ ) {
//				JSONObject o = arr.getJSONObject(i);
//				System.out.println("번호 : " + o.getInt("no"));
//				System.out.println("제목 : " + o.getString("title"));
//				System.out.println("미리보기 : " + o.getString("preview"));
//				System.out.println("저자 : " + o.getString("author"));
//				System.out.println("가격 : " + o.getInt("price"));
//				System.out.println();
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
