package com.movieflix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieflix.entities.movie;
import com.movieflix.repositories.movierepository;

@Service
public class movieserviceimplementation implements movieservice
{
 @Autowired
 movierepository movrepo;
	
	
	@Override
	public String addmovie(movie mov) {
		movrepo.save(mov);
		return "movie is added";
	}

	@Override
	public List<movie>viewmovie() {
		List<movie>movielist=movrepo.findAll();
		return movielist;
	}
}
