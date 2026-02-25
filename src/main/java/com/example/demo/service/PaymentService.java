package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Payment;
import com.example.demo.repository.PaymentRepository;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepo;

    public PaymentService(PaymentRepository paymentRepo) {
        this.paymentRepo = paymentRepo;
    }

    // ADD PAYMENT
    public Payment addPayment(Payment payment) {

        if (payment.getAmount() <= 0) {
            throw new RuntimeException("Amount must be greater than 0");
        }

        return paymentRepo.save(payment);
    }

    // GET USER PAYMENTS (excluding deleted)
    public List<Payment> getPaymentsByUser(int userId) {
        return paymentRepo.findByCreatedBy_IdAndIsDeletedFalse(userId);
    }

    // UPDATE PAYMENT
    public Payment updatePayment(Payment payment) {
        return paymentRepo.save(payment);
    }

    // SOFT DELETE
    public String deletePayment(int id) {

        Payment payment = paymentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        payment.setDeleted(true);
        paymentRepo.save(payment);

        return "Payment soft deleted successfully";
    }

    // FILTER BY CATEGORY
    public List<Payment> getPaymentsByCategory(int categoryId) {
        return paymentRepo.findByCategory_IdAndIsDeletedFalse(categoryId);
    }

    // FILTER BY TYPE
    public List<Payment> getPaymentsByType(String paymentType) {
        return paymentRepo.findByPaymentTypeAndIsDeletedFalse(paymentType);
    }

    // FILTER USER + TYPE
    public List<Payment> getUserPaymentsByType(int userId, String paymentType) {
        return paymentRepo.findByCreatedBy_IdAndPaymentTypeAndIsDeletedFalse(userId, paymentType);
    }
}