package com.timestream.task.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Rollback;

import com.timestream.task.model.Cart;
import com.timestream.task.model.Item;
import com.timestream.task.repository.CartRepository;

@SpringBootTest
public class CartServiceTest {
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	CartService cartservice;
	
	
	// JUnit test for get all Carts
    @Test
    @Order(1)
    @Rollback(value = false)
    public void getAllCartsTest(){
    	Cart cart = new Cart();
    	cart.setUserName("Tayyba");
    	
    	List<Item> items = new ArrayList<Item>();
    	
    	Item itemOne = new Item();
    	itemOne.setItemName("Shoes");
    	
    	Item itemTwo = new Item();
    	itemTwo.setItemName("Bag");
    	
    	items.add(itemOne);
    	items.add(itemTwo);
    	cart.setItems(items);
    	cartRepository.save(cart);
    	
    	Cart cart2 = new Cart();
    	cart2.setUserName("Fatima");

    	List<Item> items2 = new ArrayList<Item>();
    	Item itemOne2 = new Item();
    	Item itemTwo2 = new Item();
    	itemOne2.setItemName("Spoon");
       	itemTwo2.setItemName("Bottle");
       	
    	items.add(itemOne2);
    	items.add(itemTwo2);
    	cart2.setItems(items2);
    	cartRepository.save(cart2);

    	List<Cart> carts = cartservice.getAllCarts();
        assertEquals(carts.size(),2);

    }
}
