package com.movieflix.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class navcontroller {

@GetMapping("map-register")
public String mapregister()
{
	return "register";
}
@GetMapping("map-login")
public String maplogin()
{
	return "login" ;
}
@GetMapping("map-addmovie")
public String mapaddmovie()
{
	return "addmovie";
}

}
