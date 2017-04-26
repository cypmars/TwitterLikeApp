package com.polytech.services.business;


import com.polytech.models.Comment;
import com.polytech.models.Like;
import com.polytech.models.Post;
import com.polytech.repository.CommentRepository;
import com.polytech.repository.LikeRepository;
import com.polytech.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;




@Component
public class PublicationServiceImpl implements PublicationService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private LikeRepository likeRepository;
	@Autowired
	private CommentRepository commentRepository;

	public void post(Post post){
		postRepository.save(post);
	}

	@Override
	public void like(Like like){
		likeRepository.save(like);
	}

	@Override
	public List<Like> fetchAllLike() {
		return likeRepository.findAll();
	}


	@Override
	public List<Like> fetchAllLike(Post post) {
		return likeRepository.findByPost(post);
	}

	@Override
	public void comment(Comment comment) {
		commentRepository.save(comment);
	}

	@Override
	public List<Comment> fetchAllComment() {
		return commentRepository.findAll();
	}

	@Override
	public Post fetchPost(Long id) {
		return postRepository.findById(id);
	}

	public List<Post> fetchAll() {
		return postRepository.findAll();
	}

	@Override
	public List<Comment> fetchAllComment(Post post) {
		return commentRepository.findByPost(post);
	}
}
