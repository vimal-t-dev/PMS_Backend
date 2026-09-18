package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Payment;
import com.example.demo.service.PaymentService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/add")
    public Payment addPayment(@RequestBody Payment payment) {
        return paymentService.addPayment(payment);
    }

    @GetMapping("/user/{userId}")
    public List<Payment> getUserPayment(@PathVariable int userId) {
        return paymentService.getPaymentsByUser(userId);
    }

    @PutMapping("/update")
    public Payment updatePayment(@RequestBody Payment payment) {
        return paymentService.updatePayment(payment);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePayment(@PathVariable int id) {
        return paymentService.deletePayment(id);
    }

    @GetMapping("/category/{categoryId}")
    public List<Payment> getByCategory(@PathVariable int categoryId) {
        return paymentService.getPaymentsByCategory(categoryId);
    }

    @GetMapping("/type/{type}")
    public List<Payment> getByType(@PathVariable String type) {
        return paymentService.getPaymentsByType(type);
    }

    @GetMapping("/user/{userId}/type/{type}")
    public List<Payment> getUserPaymentsByType(@PathVariable int userId,
                                               @PathVariable String type) {
        return paymentService.getUserPaymentsByType(userId, type);
    }
}