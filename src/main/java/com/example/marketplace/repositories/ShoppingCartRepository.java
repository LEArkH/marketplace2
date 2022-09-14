package com.example.marketplace.repositories;


import com.example.marketplace.models.Client;
import com.example.marketplace.models.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    //ShoppingCart findByClient(Client client);

    ShoppingCart findByClientAndActive(Client client, Boolean active);

}
