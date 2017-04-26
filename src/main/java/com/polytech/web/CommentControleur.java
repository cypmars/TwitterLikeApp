package com.polytech.web;

import com.polytech.account.repository.UserRepository;
import com.polytech.models.Comment;
import com.polytech.models.Post;
import com.polytech.services.business.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;




@Controller
public class CommentControleur {
	@Autowired
	private PublicationService publicationService;

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/comment", method = RequestMethod.GET)
	public String comment(@RequestParam(value="id", required=true) Long idPost,
			  @RequestParam(value="content", required=true) String content,
			  Principal principal){
		Post post = publicationService.fetchPost(idPost);
		Comment comment = new Comment(post, userRepository.findByUsername(principal.getName()), content);
		if (comment.getCONTENT() != null && !comment.getCONTENT().isEmpty())
			publicationService.comment(comment);
		else
			comment.setCONTENT("ERROR empty comment");
		return "redirect:/";
	}

	@ResponseBody
	@RequestMapping(value = "/comment/count", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String commentCount(@RequestParam(value="id", required=true) Long idPost){
		Post post = publicationService.fetchPost(idPost);
		List<Comment> comments = publicationService.fetchAllComment(post);
		String template = "{\"Post\" : %s, \"comments_count\" : %d }";
		return String.format(template, post.toString(), comments.size());
	}

	@ResponseBody
	@RequestMapping(value = "/comment/for", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Comment> likeFor(@RequestParam(value="id", required=true) Long idPost){
		Post post = publicationService.fetchPost(idPost);
		List<Comment> comments = publicationService.fetchAllComment(post);
		return comments;
	}
}
