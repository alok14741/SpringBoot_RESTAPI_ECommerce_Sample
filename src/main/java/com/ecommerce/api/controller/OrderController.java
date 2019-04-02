package com.ecommerce.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.api.entity.Item;
import com.ecommerce.api.entity.Orders;
import com.ecommerce.api.entity.Response;
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
		return orderRepository.findAll();
	}

	@PostMapping(consumes = "application/json")
	public Response create(@RequestBody Iterable<Orders> orders) {
		Response response = new Response();
		StringBuilder message = new StringBuilder();
		for (Orders order : orders) {
			Item item = itemRepository.findOne(order.getItemCode());
			if (item != null) {
				if (order.getNumberOfItems() < item.getQuantity()) {
					Orders orderSaved = orderRepository.save(order);
					message.append("\n Order Placed Successfully : " + orderSaved.getOrderCode());
				} else {
					message.append("\n Out of Stock : " + order.getItemCode());
				}
			} else {
				message.append("\n Item Not Found : " + order.getItemCode());
			}
		}
		response.setMessage(message.toString());
		return response;
	}

}
