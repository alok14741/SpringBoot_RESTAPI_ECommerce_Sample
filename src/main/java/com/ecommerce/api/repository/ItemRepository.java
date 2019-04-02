package com.ecommerce.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.ecommerce.api.entity.Item;

@RestResource(exported = false)
public interface ItemRepository extends JpaRepository<Item, String>{

}
