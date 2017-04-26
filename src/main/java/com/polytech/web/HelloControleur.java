package com.polytech.web;

import com.polytech.account.repository.UserRepository;
import com.polytech.models.Post;
import com.polytech.services.business.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;




@Controller
public class HelloControleur {

	@Autowired
	PublicationService publicationService;
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String sayHello(@RequestParam(value="post", required=false, defaultValue = "") String postContent,
			       Model model, Principal principal){
		if (!postContent.equals(""))
		{
			publicationService.post(new Post(postContent, principal.getName()));
			model.addAttribute("isPosted", true);
			model.addAttribute("posted_content", postContent);
		}
		else
			model.addAttribute("isPosted", false);
		return getPosts(model, principal);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String sayHelloPOST(Post post, Model model, Principal principal){
		post.setAuthor(principal.getName());
		publicationService.post(post);

		model.addAttribute("isPosted", true);
		model.addAttribute("posted_content", post.getContent());
		return getPosts(model, principal);
	}

	private String getPosts(Model model, Principal principal){
		List<Post> posts = publicationService.fetchAll();
		model.addAttribute("posts", posts);
		model.addAttribute("username", principal.getName());
		return "index";
	}
}
