package com.timestream.task.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.timestream.task.dto.CartDto;
import com.timestream.task.model.Cart;
import com.timestream.task.model.Item;
import com.timestream.task.repository.CartRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class CartService {
	private CartRepository cartRepository;
	
	//get cart by id
	public CartService(CartRepository cartRepository){



		this.cartRepository=cartRepository;
	}
	//get all cart 
	public List<Cart> getAllCarts()   
	{  
		return cartRepository.findAll();
	}  
	
	public Cart getById(Long id) {
		Cart cart = cartRepository.getById(id);
		return cart;
	}

	//saving a specific record by using the method save() of CrudRepository  
	public void save(CartDto cartDto)   
	{  
		Cart cart = new Cart();
		List<Item> items = cartDto.getItems();
		items.sort(Comparator.comparing(Item::getItemName));
	
		cart.setItems(items);
		cart.setUserName(cartDto.getUserName());
		cartRepository.save(cart);  
	}  

}
