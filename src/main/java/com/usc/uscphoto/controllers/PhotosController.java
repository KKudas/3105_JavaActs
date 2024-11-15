package com.usc.uscphoto.controllers;

import com.usc.uscphoto.model.PhotoModel;
import com.usc.uscphoto.services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PhotosController {
//    private List<PhotoModel> db = List.of(new PhotoModel("1", "usc.jpg"));
    private Map<String, PhotoModel> db = new HashMap<>(){{
        put("1", new PhotoModel("1", "usc.jpg"));
        put("2", new PhotoModel("2", "dcism.jpg"));
    }};
    @GetMapping("/photo")
    private Collection<PhotoModel> getData(){
        return db.values();
    }

    @GetMapping("/photo/{id}")
    private PhotoModel getData(@PathVariable String id){
        PhotoModel photoModel = db.get(id);
        if(photoModel == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return db.get(id);
    }
}
