package com.ecommerce.api.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Item {

	@Id
	@Basic(optional = false)
	private String itemCode;

	@NotNull(message = "Item name is required.")
	@Basic(optional = false)
	private String name;

	@NotNull(message = "Item quantity is required.")
	@Basic(optional = false)
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
