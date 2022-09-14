package com.example.marketplace.controllers;

import com.example.marketplace.dtos.ShoppingCartDTO;
import com.example.marketplace.services.ShoppingCartServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartServices shoppingCartServices;

    @GetMapping("/shoppingCarts")
    public List<ShoppingCartDTO> getAllShoppingCarts(){
        return shoppingCartServices.getAllShoppingCarts();
    }

    @PostMapping("/shoppingCarts")
    public ResponseEntity<Object> createCart(
            Authentication authentication) {
        return shoppingCartServices.createCart(authentication);
    }

}
