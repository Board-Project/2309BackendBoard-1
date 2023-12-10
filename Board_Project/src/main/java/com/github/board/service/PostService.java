package com.github.board.service;


import com.github.board.repository.Posts.Post;
import com.github.board.repository.Posts.PostRepository;
import com.github.board.service.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final
 PostRepository postRepository;


    public Post createPost(Post post) {
        return postRepository.save(post);
    }


    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }


    public Optional<Post> getPostById(Integer id) {
        return postRepository.findById(id);
    }


    public Post updatePost(Integer id, Post updatedPost) {
        Optional<Post> existingPost = postRepository.findById(id);
        if (existingPost.isPresent()) {
            Post post = existingPost.get();
            post.setTitle(updatedPost.getTitle());
            post.setContent(updatedPost.getContent());
            return postRepository.save(post);
        } else {
            throw new NotFoundException("게시물을 찾을 수 없습니다.");
        }
    }


    public void deletePost(Integer id) {

        Optional<Post> existingPost = postRepository.findById(id);
        if (existingPost.isPresent()) {
            postRepository.deleteById(id);
        } else {
            throw new NotFoundException("게시물을 찾을 수 없습니다.");
        }
    }


    public List<Post> getPostsByAuthor(String author) {
        return postRepository.findByAuthor(author);
    }
}
