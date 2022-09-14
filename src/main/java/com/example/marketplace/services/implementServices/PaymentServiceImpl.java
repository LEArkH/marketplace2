package com.example.marketplace.services.implementServices;

import com.example.marketplace.dtos.PaymentDTO;
import com.example.marketplace.dtos.PaymentPostDTO;
import com.example.marketplace.models.Payment;
import com.example.marketplace.models.Product;
import com.example.marketplace.services.PaymentService;
import com.example.marketplace.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
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

    @Override
    public ResponseEntity<Object> createPayment(PaymentPostDTO paymentPostDTO) {

        if (paymentPostDTO.getId()==0 || paymentPostDTO.getName().isEmpty() || paymentPostDTO.getPayments().isEmpty()) {
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }

        if (paymentRepository.findByName(paymentPostDTO.getName()) != null) {
            return new ResponseEntity<>("Ya existe ese tipo de pago", HttpStatus.FORBIDDEN);
        }
        Payment payment = new Payment(paymentPostDTO.getName(),paymentPostDTO.getPayments());
        paymentRepository.save(payment);

        return new ResponseEntity<>(HttpStatus.CREATED); //si pasó los anteriores requisitos, lo crea, lo guarda y envia un mensaje 201 creado
    }
}
