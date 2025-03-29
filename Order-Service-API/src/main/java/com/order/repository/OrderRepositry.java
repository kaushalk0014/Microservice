package com.order.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.entiry.Order;

@Repository // Optional but recommended
@Primary
public interface OrderRepositry extends JpaRepository<Order, Long> {
}
