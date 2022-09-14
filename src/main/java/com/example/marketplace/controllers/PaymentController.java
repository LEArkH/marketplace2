package com.example.marketplace.controllers;


import com.example.marketplace.dtos.PatchProductDTO;
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

    @PostMapping("/payment")
    public ResponseEntity<Object> createPayment(
            @RequestBody PaymentPostDTO paymentPostDTO) {
        return paymentService.createPayment(paymentPostDTO);
    }

    @PutMapping("/payment/update/{id}")
    public ResponseEntity<Object> updatePayment(@RequestBody PaymentPostDTO paymentPostDTO, @PathVariable ("id") Long id) {
        return paymentService.updatePayment(paymentPostDTO, id); //PathVariable se usa para los id
    }
    @PatchMapping("/payment/update/{id}")
    public ResponseEntity<Object> patchPayment(@RequestBody PaymentPostDTO paymentPostDTO, @PathVariable ("id") Long id){
        return paymentService.patchPayment(paymentPostDTO, id); //con requestBody mandamos un objeto, va a usar un solo dato y va a construir un objeto con un solo dato, por ende necesita un contructor para cada atributo
    }
    @DeleteMapping("payment/delete/{id}")
    public ResponseEntity<Object> deletePayment(@PathVariable("id")Long id){
        return paymentService.deletePayment(id);
    }
}
