package com.cl.food_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cl.food_app.dto.Orders;
import com.cl.food_app.service.OrdersService;
import com.cl.food_app.structure.ResponseStructure;

@RestController
@Component

public class OrdersController {

	@Autowired
	OrdersService ordersService;
	
	@PostMapping("/orders")
	public ResponseEntity<ResponseStructure<Orders>> saveManager(@RequestBody Orders orders){
		return ordersService.saveorders(orders);
	}
	
	@GetMapping("/orders/{id}")
	public ResponseEntity<ResponseStructure<Orders>> getby(@PathVariable int id){
		return ordersService.getby(id);
	}
	
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<ResponseStructure<Orders>> delete(@PathVariable int id){
		return ordersService.delete(id);
	}
	
	@PutMapping("/orders/{id}")
	public ResponseEntity<ResponseStructure<Orders>> update(@RequestBody Orders orders,@PathVariable int id){
		return ordersService.update(orders,id);
	}
	
	@GetMapping("/orders")
	public ResponseEntity<ResponseStructure<List<Orders>>> getall(){
		return ordersService.getall();
	}
}
