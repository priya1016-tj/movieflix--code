package com.movieflix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.movieflix.entities.movie;

import com.movieflix.services.movieservice;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class moviecontroller {
	
@Autowired
movieservice movserv;

@PostMapping("addmovie")
public String addmovie(@ModelAttribute movie mov) {
	movserv.addmovie(mov);
	return "addmoviesuccess";
}
	@GetMapping("viewmovie")
	public String viewmovie(Model model)
	{
		List<movie>movielist=movserv.viewmovie();
		model.addAttribute("movie",movielist);
		return "viewmovie";
	}
	
	@GetMapping("viewmovieuser")
	public String viewmovieuser(Model model)
	{
		List<movie>movielist=movserv.viewmovie();
		model.addAttribute("movie",movielist);
		return "viewmovieuser";
	}
}
