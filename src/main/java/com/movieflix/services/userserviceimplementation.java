package com.movieflix.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieflix.entities.user;
import com.movieflix.repositories.userrepositories;


@Service
public class userserviceimplementation implements userservice
{

	@Autowired
	userrepositories urepo;
	
	@Override
	public String addusers(user usr) {
		urepo.save(usr);
		return  "user creteated" ;
	}

	@Override
	public boolean emailexits(String email) {
		//checking whether the user exits with entered email
		if(urepo.findByEmail(email)== null) {
			//if user doesn't exits,return false
			return false;
		}
		else
		{
			return true;
		}
		
	}

	@Override
	public boolean checkuser(String email, String password) {
		//checking email and getting user details from db
		user usr=urepo.findByEmail(email);
		//getting db password of user using email
		String db_password=usr.getPassword();
		//checking whether user entered password and db password same 
		if(db_password.equals(password)){
			
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
		
	@Override
	public List<user> viewuser() {
		List<user>userlist=urepo.findAll();
		return userlist;
	}

	@Override
	public user getuser(String email) {
		user user= urepo.findByEmail(email);
		return user;
	}

	@Override
	public void updateuser(user user) {
		urepo.save(user);
	}

	@Override
	public String updateprofile(user usr) {
		urepo.save(usr);
		return "updated succefully";
	}

	
}
