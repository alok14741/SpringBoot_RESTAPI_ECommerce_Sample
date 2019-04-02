package com.ecommerce.api.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Orders {

	@Id
	@NotEmpty(message = "Order Code is required.")
	@Basic(optional = false)
	private String orderCode;
	@NotEmpty(message = "Item Code is required.")
	@Basic(optional = false)
	private String itemCode;
	@NotNull(message = "Number of Items is required.")
	@Basic(optional = false)
	@Min(1)
	private int numberOfItems;
	@NotEmpty(message = "Email is Mandatory")
	@Email(message = "email should be a valid email")
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
