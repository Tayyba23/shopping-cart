package com.timestream.task.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timestream.task.dto.CartDto;
import com.timestream.task.model.Cart;
import com.timestream.task.repository.CartService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class CartController {
	@Autowired
	CartService cartService;
	
	@ApiOperation(value = "Get All Carts")
	@GetMapping("/carts")
	public List<Cart> getAllCarts() {
		 List<Cart> carts = cartService.getAllCarts();
		 return carts;
	}

	@ApiOperation(value = "Save a cart with list of items")
	@PostMapping("/carts")
	public CartDto add(@Valid @RequestBody CartDto cart) {
		  cartService.save(cart);
		 return cart;
	}

}
	