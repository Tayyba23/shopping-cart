package com.timestream.task.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.timestream.task.model.Cart;
import com.timestream.task.model.Item;


@SpringBootTest
public class CartRepositoryTest {
	
	@Autowired
	private CartRepository cartRepository;
	
	// JUnit test for save Cart
    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveCartTest(){
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
    	
        assertTrue(cart.getCartId()>0);
    }

}
