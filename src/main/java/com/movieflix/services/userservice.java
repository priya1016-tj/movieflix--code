package com.movieflix.services;

import java.util.List;

import com.movieflix.entities.user;

public interface userservice {
	public String addusers(user user);
	public boolean emailexits(String email);
	public boolean checkuser(String email,String password);
	public List<user>viewuser();
	public user getuser(String email);
	public void updateuser(user user);
	public String updateprofile(user user);

}
