package com.example.marketplace.services;

import com.example.marketplace.dtos.PaymentDTO;
import com.example.marketplace.dtos.PaymentPostDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PaymentService {
    List<PaymentDTO> getAllPayments();

    ResponseEntity<Object> createPayment(
            PaymentPostDTO paymentPostDTO) ;

}
