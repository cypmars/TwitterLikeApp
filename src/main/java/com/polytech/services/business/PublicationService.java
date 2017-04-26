package com.polytech.services.business;

import com.polytech.models.Comment;
import com.polytech.models.Like;
import com.polytech.models.Post;

import java.util.List;



public interface PublicationService {
	void post(Post post);

	void like(Like like);

	List<Like> fetchAllLike();

	List<Like> fetchAllLike(Post post);

	void comment(Comment comment);

	List<Comment> fetchAllComment();

	Post fetchPost(Long id);

	List<Post> fetchAll();

	List<Comment> fetchAllComment(Post post);
}
