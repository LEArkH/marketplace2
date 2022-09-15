package com.example.marketplace.dtos;

import com.example.marketplace.models.Payment;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PaymentDTO {

    private Long id;
    private String name;
    private List<Integer> payments;



    public PaymentDTO(Payment payment) {
        this.id = payment.getId();
        this.name = payment.getName();
        this.payments = payment.getPayments();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getPayments() {
        return payments;
    }

    public void setPayments(List<Integer> payments) {
        this.payments = payments;
    }
}
