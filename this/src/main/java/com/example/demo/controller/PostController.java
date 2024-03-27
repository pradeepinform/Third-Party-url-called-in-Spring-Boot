package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.PostService;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/posts")
    public List<Map<String, Object>> getAllPosts() {
        return postService.getPosts();
    }
    
    @GetMapping("/getPostById/{id}")
    public Map<String, Object> getPostById(@PathVariable int id)
    {
    	return postService.getPostById(id);
    }

    
    @PostMapping("/insertPosts")
    public Map<String, Object> postData(@RequestBody Map<String, Object> payload)
    {
    	return postService.insertPosts(payload);
    	
    }
    
    @PutMapping("/updatePost/{id}")
    public Map<String, Object> updatePostData(Map<String,Object> payload , @PathVariable int id)
    {
    	return postService.upadatePosts(payload, id);
    }
    
    
    @DeleteMapping("/deletePost/{id}")
    public Map<String, Object> deletePostById(@PathVariable int id)
    {
    	return postService.deletePosts(id);
    }
}
