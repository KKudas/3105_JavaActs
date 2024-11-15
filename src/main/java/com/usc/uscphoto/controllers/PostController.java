package com.usc.uscphoto.controllers;

import com.usc.uscphoto.entity.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private List<Post> posts = new ArrayList<>();
    private List<Comment> comments = new ArrayList<>();
    private List<Like> likes = new ArrayList<>();

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        post.setId(posts.size() + 1);
        post.setLikeCount(0);
        posts.add(post);
        return post;
    }

    @PostMapping("/comments")
    public Comment commentOnPost(@RequestBody Comment comment) {
        Optional<Post> post = posts.stream().filter(p -> p.getId() == comment.getPostId()).findFirst();
        if (post.isEmpty()) {
            throw new IllegalArgumentException("Post not found");
        }
        comment.setId(comments.size() + 1);
        comments.add(comment);
        return comment;
    }

    @PostMapping("/likes")
    public Post likePost(@RequestBody Like like) {
        Optional<Post> post = posts.stream().filter(p -> p.getId() == like.getPostId()).findFirst();
        if (post.isEmpty()) {
            throw new IllegalArgumentException("Post not found");
        }

        Post existingPost = post.get();
        existingPost.setLikeCount(existingPost.getLikeCount() + 1);
        like.setId(likes.size() + 1);;
        likes.add(like);
        return existingPost;
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return posts;
    }

    @GetMapping("/{postId}/comments")
    public List<Comment> getCommentsByPostId(@PathVariable int postId) {
        List<Comment> postComments = new ArrayList<>();
        for (Comment comment : comments) {
            if (comment.getPostId() == postId) {
                postComments.add(comment);
            }
        }
        return postComments;
    }

    @GetMapping("/{postId}/likes")
    public List<Like> getLikesByPostId(@PathVariable int postId) {
        List<Like> postLike = new ArrayList<>();
        for (Like like : likes) {
            if (like.getPostId() == postId) {
                postLike.add(like);
            }
        }
        return postLike;
    }
}
