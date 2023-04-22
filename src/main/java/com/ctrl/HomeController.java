package com.ctrl;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entities.Post;
import com.entities.PostImage;
import com.entities.PostInterface;
import com.entities.User;

import pattern.ProxyPattern;
import pattern.StrategyPattern;
import pattern.DateSortingStrategy;
import pattern.FactoryPattern;
import pattern.PopularitySortingStrategy;
import pattern.PostManager;

import com.service.DAO;

@Controller
public class HomeController {

	ProxyPattern pattern;
	DAO dao;
	PostManager postmanager;
	FactoryPattern factoryPattern;;

	public HomeController() {
		super();
		pattern = new ProxyPattern();
		dao = new DAO();
		postmanager = new PostManager();
		factoryPattern = new FactoryPattern();
	}

	@RequestMapping("/home/sortDate")
	public String homeDate(Model m) {

		StrategyPattern strategy = new DateSortingStrategy();
		postmanager.setSortingStrategy(strategy);
		postmanager.sortPosts();
		List<Post> list = postmanager.getPosts();
		List<PostImage> list2 = dao.getAllImages();
		m.addAttribute("page", "home");
		m.addAttribute("posts", list);
		return "home";
	}

	@RequestMapping("/home/sortPopularity")
	public String homePopularity(Model m) {

		StrategyPattern strategy = new PopularitySortingStrategy();
		postmanager.setSortingStrategy(strategy);
		postmanager.sortPosts();
		List<Post> list = postmanager.getPosts();

		m.addAttribute("page", "home");
		m.addAttribute("posts", list);
		return "home";
	}

	@RequestMapping("/login")
	public String login(Model m) {

		m.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping("/fetch")
	public String fetch(@ModelAttribute("user") User u, Model m) {

		String msg;
		if (pattern.userPreprocess(u, "login", m)) {
			msg = (String) m.getAttribute("status");
			m.addAttribute("msg", msg);

			return "home";
		} else {
			msg = (String) m.getAttribute("status");
			m.addAttribute("msg", msg);
			return "login";
		}
	}

	@RequestMapping("/registration")
	public String registration(Model m) {

		m.addAttribute("user", new User());
		return "registration";
	}

	@RequestMapping("/save")
	public String save(@ModelAttribute("user") User u, Model m) {

		String msg;
		if (pattern.userPreprocess(u, "signIn", m)) {
			msg = (String) m.getAttribute("status");
			m.addAttribute("msg", msg);
			return "home";
		} else {
			msg = (String) m.getAttribute("status");
			m.addAttribute("msg", msg);
			return "registration";
		}
	}

	@RequestMapping("/add")
	public String add(Model m) {

		m.addAttribute("page", "add");
		return "home";
	}

	@RequestMapping("/add/{t}")
	public String add(@PathVariable String t, Model m) {

		System.out.println(t);
		m.addAttribute("postType", t);

		m.addAttribute("post", factoryPattern.getPostInstance(t));

		return "home";
	}

	@RequestMapping(value = "/deletePost/{t}")
	public String deletePost(@PathVariable int t, Model m) {

		dao.deletePost(t + 1);
		m.addAttribute("page", "home");
		return "home";
	}

	@RequestMapping(value = "/likePost/{t}")
	public String likePost(@PathVariable int t, Model m) {

		dao.updatePost(t + 1);
		m.addAttribute("page", "home");
		return "home";
	}

	@RequestMapping("/text")
	public String textPost(Model m) {

		PostInterface post = new Post();
		m.addAttribute("postType", "text");
		m.addAttribute("post", post);
		return "home";
	}

	@RequestMapping("/image")
	public String imagePost(Model m) {

		PostInterface post = new PostImage();
		m.addAttribute("postType", "text");
		m.addAttribute("post", post);
		return "home";
	}

	@RequestMapping("add/home/saveImage")
	public String saveImage(@ModelAttribute("post") PostImage p, Model m) {

		String msg = (String) m.getAttribute("status");
		pattern.postPreprocess(p, m);
		m.addAttribute("msg", msg);
		return "home";

	}

	@RequestMapping("/add/home/saveText")
	public String saveText(@ModelAttribute("post") Post p, Model m) {

		String msg = (String) m.getAttribute("status");
		pattern.postPreprocess(p, m);
		m.addAttribute("msg", msg);
		return "home";

	}
}
