package com.example.marketplace.services;

import com.example.marketplace.dtos.PaymentDTO;

import java.util.List;

public interface PaymentService {
    List<PaymentDTO> getAllPayments();
}
