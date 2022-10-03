package com.digitalbooks.login.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.digitalbooks.login.app.entity.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer>, JpaRepository<Payment, Integer>{

	public List<Payment> findByReaderMail(String readerMail);
	
	public List<Payment> findByPaymentId(int paymentId);

}
