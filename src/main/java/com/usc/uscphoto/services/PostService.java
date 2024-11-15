package com.usc.uscphoto.services;

import org.springframework.stereotype.Component;

@Component
public class PostService {
    public String findAll(){
        return "All Posts";
    }

    public String findById(){
        return "Post 1";
    }
}
