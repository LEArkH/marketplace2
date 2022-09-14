package com.example.marketplace.services;


import com.example.marketplace.dtos.ShoppingCartDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface ShoppingCartServices {

    List<ShoppingCartDTO> getAllShoppingCarts();

    ResponseEntity<Object> createCart(Authentication authentication);

}
