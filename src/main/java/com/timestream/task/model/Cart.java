package com.timestream.task.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.timestream.task.Audit.DateAudit;

@Entity
@Table(name = "cart")
public class Cart  extends DateAudit {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cartId;

	@Column(name="user_name")
	@NotNull
	private String userName;
	
	@OneToMany
	(cascade = CascadeType.PERSIST)
    private List<Item> items= new ArrayList<Item>();


	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

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
		System.out.println(items.size());
		this.items = items;
	}


}
