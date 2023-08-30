package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Cart {
     @Id
     private int cartid;
     private int quantity;
     
     @OneToOne(cascade = CascadeType.ALL)
     @JoinColumn(name = "customerid")
     private Registration r;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(int cartid, int quantity, Registration r) {
		super();
		this.cartid = cartid;
		this.quantity = quantity;
		this.r = r;
	}

	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Registration getR() {
		return r;
	}

	public void setR(Registration r) {
		this.r = r;
	}
	
     
	
     
}