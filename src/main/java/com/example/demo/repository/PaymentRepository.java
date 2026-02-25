package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	
	List<Payment> findByIsDeletedFalse();
	List<Payment> findByCreatedBy_IdAndIsDeletedFalse(int userId);

    List<Payment> findByCategory_IdAndIsDeletedFalse(int categoryId);

    List<Payment> findByPaymentTypeAndIsDeletedFalse(String paymentType);

    List<Payment> findByCreatedBy_IdAndPaymentTypeAndIsDeletedFalse(int userId, String paymentType);
}
