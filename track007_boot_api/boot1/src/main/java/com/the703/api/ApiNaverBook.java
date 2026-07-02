package com.the703.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service // db에 저장하겠다 service
public class ApiNaverBook {

	private final RestClient restClient;
	private final ObjectMapper objectMapper = new ObjectMapper();
	@Value("${book.clientId}") private String clientId;
	@Value("${book.clientSecret}") private String clientSecret;
	
	public ApiNaverBook(RestClient.Builder restClientBuilder) {
		this.restClient = restClientBuilder.build(); //외부통신하고 값 return
	}
	
	public List<BookDto> getBooks(String query){
		//1. 주소 - UriComponentsBuilder(자동인코딩 지원)
	    java.net.URI uri = UriComponentsBuilder 
                .fromUriString("https://openapi.naver.com/v1/search/book.json")
                .queryParam("query", query)  //받아온값
                .build()  
                .toUri();
	    
		//2. 설정값 : responseBody
	    List<BookDto> result = new ArrayList<>();
	    try{
	    String responseBody = restClient.get()  // GET
	    								.uri(uri)
	    								.header("X-Naver-Client-Id", clientId)
	    								.header("X-Naver-Client-Secret", clientSecret)
	    								.retrieve() // 설정내용을 http 요청주고 응답 받아와
 	    								.body(String.class);
		//3. 값받기
	    JsonNode root =  objectMapper.readTree(responseBody); // JSON 객체로 변환
	    for( JsonNode item : root.path("items")) {
	    	BookDto book = new BookDto();
	    	book.setTitle(item.path("title").asText());
	    	book.setImage(item.path("image").asText());
	    	book.setAuthor(item.path("author").asText());
	    	result.add(book);
	    }
	    
	    System.out.println("...." + root);
	    
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
		return result;
	}
	
	// title, author, image
}
/*

> GET /v1/search/book.xml?query=%EC%A3%BC%EC%8B%9D&display=10&start=1 HTTP/1.1
> Host: openapi.naver.com
> User-Agent: curl/7.49.1
> Accept: * / *
> X-Naver-Client-Id: {애플리케이션 등록 시 발급받은 클라이언트 아이디 값}
> X-Naver-Client-Secret: {애플리케이션 등록 시 발급받은 클라이언트 시크릿 값}

요청 예 
curl "https://openapi.naver.com/v1/search/book.xml?query=%EC%A3%BC%EC%8B%9D&display=10&start=1" \
    -H "X-Naver-Client-Id: {애플리케이션 등록 시 발급받은 클라이언트 아이디 값}" \
    -H "X-Naver-Client-Secret: {애플리케이션 등록 시 발급받은 클라이언트 시크릿 값}" -v
*/