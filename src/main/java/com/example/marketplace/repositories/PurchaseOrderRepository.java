package com.example.marketplace.repositories;

import com.example.marketplace.models.PurchaseOrder;
import com.example.marketplace.models.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {

    List<PurchaseOrder> findByShoppingCart(ShoppingCart shoppingCart);

}
