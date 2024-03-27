package com.example.demo.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private RestTemplate restTemplate;

	String baseUrl = "https://jsonplaceholder.typicode.com/";
	StringBuilder stringBuilder = new StringBuilder(baseUrl);
	String POST = "/posts";
	String POSTBYID = "/posts/";

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getPosts() {

		String url = stringBuilder.append(POST).toString();

		HttpEntity<Void> httpEntity = new HttpEntity<>(getHttpHeaders());
		var response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, List.class);
		return response.getBody();

	}

	private HttpHeaders getHttpHeaders() {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;

	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getPostById(int id) {
		HttpEntity<Void> httpEntity = new HttpEntity<>(getHttpHeaders());
		String url = stringBuilder.append(POSTBYID).append(id).toString();
		var response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Map.class);
		return response.getBody();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> insertPosts(Map<String, Object> payload) {
		HttpEntity<Map> httpEntity = new HttpEntity<>(payload, getHttpHeaders());
		String url = stringBuilder.append(POST).toString();
		var response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Map.class);

		return response.getBody();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> upadatePosts(Map<String, Object> payload, int id) {
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(payload, getHttpHeaders());
		String url = stringBuilder.append(POSTBYID).append(id).toString();
		var response = restTemplate.exchange(url, HttpMethod.PUT, httpEntity, Map.class);
		return response.getBody();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> deletePosts(int id) {
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(getHttpHeaders());
		String url = stringBuilder.append(POSTBYID).append(id).toString();
		var response = restTemplate.exchange(url, HttpMethod.DELETE, httpEntity, Map.class);
		return response.getBody();
	}

}
