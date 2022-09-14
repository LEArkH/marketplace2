package com.example.marketplace.services.implementServices;

import com.example.marketplace.dtos.PaymentDTO;
import com.example.marketplace.services.PaymentService;
import com.example.marketplace.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;


    @Override
    public List<PaymentDTO> getAllPayments() {
        return paymentRepository.findAll().stream().map(PaymentDTO::new).collect(Collectors.toList());
    }
}
