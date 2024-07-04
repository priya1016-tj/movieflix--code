package com.movieflix.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.movieflix.entities.movie;
import com.movieflix.entities.user;
import com.movieflix.repositories.userrepositories;
import com.movieflix.services.movieservice;
import com.movieflix.services.userservice;

import jakarta.servlet.http.HttpSession;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class usercontroller {
	@Autowired
	userservice userv;
	
	@Autowired
	movieservice movserv;
	
	@Autowired
	userrepositories urepo;
	
	@PostMapping("register")
	public String addusers(@ModelAttribute user usr) {
		boolean status=userv.emailexits(usr.getEmail());
		if(status==true) {
			return "regfail";	
		}
		else {
			userv.addusers(usr);
			return "registersuccess";
		}
		
	}	
	@PostMapping("login")
	public String validateuser(@RequestParam String email,
			@RequestParam String password,HttpSession session)
	{
		boolean loginstatus=userv.checkuser(email, password);
		if(loginstatus==true)
		{
			session.setAttribute("email",email);
			if(email.equals("admin@gmail.com")) 
			{
				return "adminhome";
			}
			
		else
		{
			return "home";
		}
	}
	else {
		return "login";
	}
	}
	
	
	@GetMapping("viewuser")
	public String viewuser(Model model) {
		List<user> userlist = userv.viewuser();
		model.addAttribute("user",userlist);
		return "viewuser";
}
	
	 
	@GetMapping("exploremovies")
	public String exploremovie(Model model ,HttpSession session)
	{
		//getting the email from session
		String email=(String)session.getAttribute("email");
		//getting the user details for email
		user usr=userv.getuser(email);
		//checking whether user is premium
		if(usr.isPremium()==true)
		{
			//getting the list of movies
			List<movie>movielist=movserv.viewmovie();
			//adding the movie details in maodel
			model.addAttribute("movie",movielist);
			//if premium show movies
			return "viewmovieuser";
		}
		else
		{
			//other wise make payment
			return "payment";
		}
		
	}
	@GetMapping("logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "login";
	}
	
	
	@GetMapping("updateprofile")
    public String showUpdateProfileForm(Model model) {
        //  pass a new User object to the form
        model.addAttribute("user", new user());
        return "updateprofile"; 
    }
	@PostMapping("updateprofile")
    public String updateProfile(@ModelAttribute user user, Model model) {
        userv.updateprofile(user);
        model.addAttribute("message", "Profile updated successfully");
        return "updateprofile"; 
    }
	

    
    @GetMapping("/delete/{id}")
    public String deleteUser(@RequestParam int id) {
        // Delete user logic 	
        urepo.deleteById(id); 
        return "redirect:/userview"; // Redirect to user list page after deletion
    }
}
	
	
	
