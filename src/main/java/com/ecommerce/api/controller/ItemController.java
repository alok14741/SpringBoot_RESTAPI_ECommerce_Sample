package com.ecommerce.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.api.entity.Item;
import com.ecommerce.api.entity.Response;
import com.ecommerce.api.exceptions.RecordNotFoundException;
import com.ecommerce.api.repository.ItemRepository;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/items")
public class ItemController {

	@Autowired
	private ItemRepository itemRepository;

	@GetMapping
	public Iterable<Item> findAll() {
		Iterable<Item> items = itemRepository.findAll();
		int counter = 0;
		for (@SuppressWarnings("unused") Object i : items) {
			counter++;
		}
		if (counter == 0) {
			throw new RecordNotFoundException("No Items Exists in DB");
		}
		return items;
	}

	@GetMapping(path = "{itemID}")
	public Item find(@PathVariable("itemID") String itemID) {
		Item item = itemRepository.findOne(itemID);
		if (item == null) {
			throw new RecordNotFoundException("Item Code-" + itemID);
		}
		return item;
	}

	@PostMapping(consumes = "application/json")
	public Response create(@Valid @RequestBody Item item) {
		Item insert = itemRepository.save(item);
		Response response = new Response();
		if (insert != null) {
			response.setMessage("Item Inserted Successfully to DB");
		} else {
			response.setMessage("Something wrong with DB or Value");
		}
		return response;
	}

	@DeleteMapping(path = "{itemID}")
	public void delete(@PathVariable("itemID") String itemID) {
		itemRepository.delete(itemID);
	}

	@PutMapping(path = "{itemID}")
	public Item update(@PathVariable("itemID") String itemID, @RequestBody Item item) throws BadHttpRequest {
		if (itemRepository.exists(itemID)) {
			item.setItemCode(itemID);
			return itemRepository.save(item);
		} else {
			throw new BadHttpRequest();
		}
	}

}
