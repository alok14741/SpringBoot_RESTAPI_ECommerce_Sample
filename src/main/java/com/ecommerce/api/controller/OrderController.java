package com.ecommerce.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.api.entity.Item;
import com.ecommerce.api.entity.Orders;
import com.ecommerce.api.entity.Response;
import com.ecommerce.api.exceptions.RecordNotFoundException;
import com.ecommerce.api.repository.ItemRepository;
import com.ecommerce.api.repository.OrderRepository;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ItemRepository itemRepository;

	@GetMapping
	public Iterable<Orders> findAll() {
		Iterable<Orders> orders = orderRepository.findAll();
		int counter = 0;
		for (@SuppressWarnings("unused")
		Object i : orders) {
			counter++;
		}
		if (counter == 0) {
			throw new RecordNotFoundException("No Items Exists in DB");
		}
		return orders;
	}
	
	/**
	 * Iterate through the loops of orders
	 * Check if items is valid then if it is out of stock
	 * Check individual items and give error or success for the same.
	 * @param orders
	 * @return Response
	 */
	@PostMapping(consumes = "application/json")
	public Response create(@Valid @RequestBody Iterable<Orders> orders) {
		Response response = new Response();
		StringBuilder message = new StringBuilder();
		for (Orders order : orders) {
			Item item = itemRepository.findOne(order.getItemCode());
			if (item != null) {
				if (order.getNumberOfItems() < item.getQuantity()) {
					Orders orderSaved = orderRepository.save(order);
					message.append("Order Placed Successfully : " + orderSaved.getOrderCode());
					update(item, item.getQuantity() - order.getNumberOfItems());
				} else {
					message.append("Out of Stock : " + order.getItemCode());
				}
			} else {
				message.append("Item Not Found : " + order.getItemCode());
			}
		}
		response.setMessage(message.toString());
		return response;
	}
	
	/**
	 * Update the quantity of items in DB after successful order
	 * @param item
	 * @param remaining
	 */
	public void update(Item item, int remaining) {
		if (itemRepository.exists(item.getItemCode())) {
			item.setQuantity(remaining);
			itemRepository.save(item);
		}
	}

}
