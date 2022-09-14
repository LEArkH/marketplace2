package com.example.marketplace.services;

import com.example.marketplace.dtos.PatchProductDTO;
import com.example.marketplace.dtos.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductServices {

    List<ProductDTO> getAllProducts();

    public ResponseEntity<Object> createProduct(
            @RequestParam String name, @RequestParam double price, //recibo estos parametros por el formulario de frontend
            @RequestParam int stock);


    ResponseEntity<Object> updateProduct(@PathVariable ("id") Long id, @RequestParam String name, @RequestParam double price, @RequestParam  int stock);

    ResponseEntity<Object> deleteProduct(@PathVariable ("id") Long id);

    ResponseEntity<Object> patchProduct(Long id, PatchProductDTO patchProductDTO);
}
