package com.example.marketplace.services;

import com.example.marketplace.dtos.PatchProductDTO;
import com.example.marketplace.dtos.PaymentDTO;
import com.example.marketplace.dtos.PaymentPostDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface PaymentService {
    List<PaymentDTO> getAllPayments();

    ResponseEntity<Object> createPayment(
            PaymentPostDTO paymentPostDTO) ;


    ResponseEntity<Object> updatePayment(@RequestBody PaymentPostDTO paymentPostDTO, @PathVariable ("id") Long id);

    ResponseEntity<Object> patchPayment(@RequestBody PaymentPostDTO paymentPostDTO, @PathVariable ("id") Long id);

    ResponseEntity<Object> deletePayment(@PathVariable("id")Long id);

}
