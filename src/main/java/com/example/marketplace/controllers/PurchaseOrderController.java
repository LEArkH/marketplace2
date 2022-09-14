package com.example.marketplace.controllers;

import com.example.marketplace.dtos.PurchaseOrderDTO;
import com.example.marketplace.services.PurchaseOrderServices;
import com.example.marketplace.dtos.PatchPurchaseItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderServices purchaseOrderServices;

    @GetMapping("/purchaseOrders")
    public List<PurchaseOrderDTO> getAllPurchaseOrders(){
        return purchaseOrderServices.getAllPurchaseOrders();
    }

    @PostMapping("/addItemToCart")
    public ResponseEntity<Object> createPurchaseOrder(
            @RequestParam String nameProduct, @RequestParam int cant, Authentication authentication
            ) {
        return purchaseOrderServices.createPurchaseOrder(nameProduct, cant, authentication);
    }

    @DeleteMapping("/deleteItemFromCart")
    public ResponseEntity<Object> deleteItem(@PathVariable("id")Long id){
        return purchaseOrderServices.deleteItem(id);
}

    @PatchMapping("/update/items/{id}")
    public ResponseEntity<Object> patchItem(@RequestBody PatchPurchaseItemDTO patchPurchaseItemDTO, @PathVariable ("id") Long id){
        return purchaseOrderServices.patchItem(id, patchPurchaseItemDTO);
    }

    }
