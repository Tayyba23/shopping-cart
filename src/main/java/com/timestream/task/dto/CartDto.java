package com.timestream.task.dto;

import java.util.ArrayList;
import java.util.List;

import com.sun.istack.NotNull;
import com.timestream.task.model.Item;

public class CartDto {
	@NotNull
	private String userName;
	
    private List<Item> items= new ArrayList<Item>();
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}

    
}
