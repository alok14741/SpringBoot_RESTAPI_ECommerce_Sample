package com.ecommerce.api.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Item {

	@Id
	@NotEmpty(message = "Item Code is required.")
	@Basic(optional = false)
	private String itemCode;

	@NotEmpty(message = "Item name is required.")
	@Basic(optional = false)
	private String name;

	@NotNull(message = "Item quantity is required.")
	@Min(1)
	private int quantity;

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "User{" + "itemCode='" + itemCode + '\'' + ", name='" + name + '}';
	}

}
