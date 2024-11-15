package com.usc.uscphoto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

public class Like {
    private int id;
    private int postId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
}
