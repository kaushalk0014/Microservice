package com.payment.service.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payment.service.entiry.Payment;

@Repository
public interface PaymentRepositry  extends JpaRepository<Payment, Integer>{

}
