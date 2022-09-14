package com.example.marketplace.repositories;

import com.example.marketplace.models.ShoppingCart;
import com.example.marketplace.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    Invoice findByShoppingCart(ShoppingCart shoppingCart);

}
