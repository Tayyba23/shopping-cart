package com.timestream.task.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.istack.NotNull;
import com.timestream.task.dto.CartDto;
import com.timestream.task.model.Cart;
import com.timestream.task.service.CartService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api")
public class CartController {
	
	private CartService cartService;
	
	 public CartController(CartService service) {
	        this.cartService = service;
	 }
	 
	@ApiOperation(value = "Get All Carts")
	@GetMapping("carts")
	public List<Cart> getAllCarts() {
		 List<Cart> carts = cartService.getAllCarts();
		 return carts;
	}

	@ApiOperation(value = "Get Cart by id")
	@GetMapping("carts/{id}")
	public Cart getById(@NotNull @PathVariable long id) {
		Cart cart = cartService.getById(id);
		return cart;
	}
	
	@ApiOperation(value = "Save a cart with list of items")
	@PostMapping("carts")
	public CartDto add(@Valid @RequestBody CartDto cart) {
		  cartService.save(cart);
		 return cart;
	}
	
	

}
	