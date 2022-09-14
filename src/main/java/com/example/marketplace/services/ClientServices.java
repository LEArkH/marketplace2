package com.example.marketplace.services;

import com.example.marketplace.dtos.ClientDTO;
import com.example.marketplace.dtos.PatchClientDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ClientServices {

    List<ClientDTO> getAllClients();

    ClientDTO getClientById(Long id);

    ClientDTO getClient(Authentication authentication);

    ResponseEntity<Object> register(

            @RequestParam String firstName, @RequestParam String lastName, //recibo estos parametros por el formulario de frontend

            @RequestParam String email, @RequestParam String address, @RequestParam String password);
    ResponseEntity<Object> patchClient(Long id, PatchClientDTO patchClientDTO);

    ResponseEntity<Object> deleteClient(@PathVariable("id") Long id);
}


