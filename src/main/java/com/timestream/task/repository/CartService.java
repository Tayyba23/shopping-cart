package com.timestream.task.repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timestream.task.dto.CartDto;
import com.timestream.task.model.Cart;
import com.timestream.task.model.Item;

@Service  
public class CartService {
	@Autowired  
	CartRepository cartRespository;
	
	
	public List<Cart> getAllCarts()   
	{  
	List<Cart> carts = new ArrayList<Cart>();  
	cartRespository.findAll().forEach(
			cart -> carts.add(cart));  
	return carts;  
	}  

	//saving a specific record by using the method save() of CrudRepository  
	public void save(CartDto cartDto)   
	{  
	Cart cart = new Cart();
	List<Item> items = cartDto.getItems();
	items.sort(Comparator.comparing(Item::getItemName));

	cart.setItems(items);
	cart.setUserName(cartDto.getUserName());
	cartRespository.save(cart);  
	}  

}
