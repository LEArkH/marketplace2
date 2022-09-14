package com.example.marketplace.repositories;

import com.example.marketplace.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Payment findByName(String typePayment);

}
