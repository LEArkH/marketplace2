package com.example.marketplace.controllers;


import com.example.marketplace.dtos.PaymentDTO;
import com.example.marketplace.dtos.PaymentPostDTO;
import com.example.marketplace.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment")
    public List<PaymentDTO> getAllPayments(){
        return paymentService.getAllPayments();
    }

    @PostMapping("/products")
    public ResponseEntity<Object> createPayment(
            @RequestBody PaymentPostDTO paymentPostDTO) {
        return paymentService.createPayment(paymentPostDTO);
    }

}
