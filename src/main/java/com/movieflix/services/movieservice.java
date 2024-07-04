package com.movieflix.services;

import java.util.List;

import com.movieflix.entities.movie;

public interface movieservice {
	
	public String addmovie(movie mov);
	
	public List<movie>viewmovie();

}
