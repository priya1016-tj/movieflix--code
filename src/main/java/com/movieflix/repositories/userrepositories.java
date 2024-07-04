package com.movieflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieflix.entities.user;

public interface userrepositories extends JpaRepository<user, Integer>
{
	 user findByEmail(String email);

	
}
