package com.tap.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orderitem")
public class orderitem 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="oiid")
	private int oiid;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private Orders orders;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="menu_id")
	private Menu menu;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="subtotal")
	private int subtotal;
	
	public orderitem() {
		super();
	}

	public orderitem(Orders orders, Menu menu, int quantity, int subtotal) {
		super();
		this.orders = orders;
		this.menu = menu;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}

	public int getOiid() {
		return oiid;
	}

	public void setOiid(int oiid) {
		this.oiid = oiid;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}
}
