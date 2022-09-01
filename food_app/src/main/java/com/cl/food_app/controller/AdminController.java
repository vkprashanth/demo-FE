package com.cl.food_app.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cl.food_app.dto.Admin;
import com.cl.food_app.service.AdminService;
import com.cl.food_app.structure.ResponseStructure;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")

public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@PostMapping("/admin")
	
	
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}
	
	@GetMapping("/admin/{id}")
	public ResponseEntity<ResponseStructure<Admin>> getby(@PathVariable int id) {
		return adminService.getby(id);
	}
	
	@DeleteMapping("/admin/{id}")
	public ResponseEntity<ResponseStructure<Admin>> delete(@PathVariable int id) {
		return adminService.delete(id);
	}
	
	@PutMapping("/admin/{id}")
	public ResponseEntity<ResponseStructure<Admin>> updateadmin(@RequestBody Admin admin,@PathVariable int id) {
		return adminService.updateadmin(admin, id);
	}
	
	@GetMapping("/admin")
	public ResponseEntity<ResponseStructure<List<Admin>>> getall(){
		return adminService.getall();
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/getby")
	public Admin get(@RequestBody Admin admin) throws Exception{
		return adminService.findbyEmailnPassword(admin);
		
	}
	
}

