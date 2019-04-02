package com.ecommerce.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.ecommerce.api.entity.Orders;

@RestResource(exported = false)
public interface OrderRepository extends JpaRepository<Orders, String> {

}
