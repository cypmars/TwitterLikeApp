package com.polytech.repository;


import com.polytech.models.Post;

import java.util.List;



public interface PostRepository {
	void save(Post post);

	Post findById(long id);

	List<Post> findAll();
}
