package com.cl.food_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cl.food_app.dto.Products;
import com.cl.food_app.service.ProductsService;
import com.cl.food_app.structure.ResponseStructure;

@RestController
public class ProductsControler {
	
	@Autowired
	ProductsService productsService;
	
	@PostMapping("/products")
	public ResponseEntity<ResponseStructure<Products>> saveManager(@RequestBody Products products){
		return productsService.saveProducts(products);
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<ResponseStructure<Products>> getby(@PathVariable int id){
		return productsService.getby(id);
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<ResponseStructure<Products>> delete(@PathVariable int id){
		return productsService.delete(id);
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<ResponseStructure<Products>> update(@RequestBody Products products,@PathVariable int id){
		return productsService.update(products, id);
	}
	
	@GetMapping("/products")
	public ResponseEntity<ResponseStructure<List<Products>>> getall(){
		return productsService.getall();
	}

}
