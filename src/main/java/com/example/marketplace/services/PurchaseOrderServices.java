package com.example.marketplace.services;

import com.example.marketplace.dtos.PurchaseOrderDTO;
import com.example.marketplace.dtos.PatchPurchaseItemDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PurchaseOrderServices {

    List<PurchaseOrderDTO> getAllPurchaseOrders();

    ResponseEntity<Object> createPurchaseOrder(
            @RequestParam String nameProduct, @RequestParam int cant, Authentication authentication
    );

    ResponseEntity<Object> deleteItem(@PathVariable("id") Long id);

    ResponseEntity<Object> patchItem(Long id, PatchPurchaseItemDTO patchPurchaseItemDTO);
}
