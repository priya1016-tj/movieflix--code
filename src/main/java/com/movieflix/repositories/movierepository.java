package com.movieflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieflix.entities.movie;

public interface movierepository extends JpaRepository<movie, Integer>
{

}
