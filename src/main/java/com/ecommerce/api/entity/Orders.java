package com.ecommerce.api.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Orders {

	@Id
	@Basic(optional = false)
	private String orderCode;
	@NotNull(message = "Item Code is required.")
	@Basic(optional = false)
	private String itemCode;
	@NotNull(message = "Number of Items is required.")
	@Basic(optional = false)
	private int numberOfItems;
	@NotNull(message = "Email is Mandatory")
	private String email;

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
