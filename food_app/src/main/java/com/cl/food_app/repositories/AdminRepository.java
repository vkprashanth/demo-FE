package com.cl.food_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cl.food_app.dto.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	public Admin findByEmailAndPassword(String email, String password);
	
}
