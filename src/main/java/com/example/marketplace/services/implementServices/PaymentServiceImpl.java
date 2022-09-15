package com.example.marketplace.services.implementServices;

import com.example.marketplace.dtos.PaymentDTO;
import com.example.marketplace.dtos.PaymentPostDTO;
import com.example.marketplace.models.Invoice;
import com.example.marketplace.models.Payment;
import com.example.marketplace.models.Product;
import com.example.marketplace.repositories.InvoiceRepository;
import com.example.marketplace.services.PaymentService;
import com.example.marketplace.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;


    @Override
    public List<PaymentDTO> getAllPayments() {
        return paymentRepository.findAll().stream().map(PaymentDTO::new).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<Object> createPayment(PaymentPostDTO paymentPostDTO) {

        if (paymentPostDTO.getName().isEmpty() || paymentPostDTO.getPayments().isEmpty()) {
            return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }

        if (paymentPostDTO.getName().equals("Debit")){
            if (paymentPostDTO.getPayments().size()>1){
                return new ResponseEntity<>("Debito solo permite 1 pago", HttpStatus.FORBIDDEN);
            }
            if (paymentPostDTO.getPayments().get(0)!=1){
                return new ResponseEntity<>("Debito solo permite 1 pago", HttpStatus.FORBIDDEN);
            }
        }

        if (paymentPostDTO.getName().equals("Cash")){
            if (paymentPostDTO.getPayments().size()>1){
                return new ResponseEntity<>("Cash solo permite 1 pago", HttpStatus.FORBIDDEN);
            }
            if (paymentPostDTO.getPayments().get(0)!=1){
                return new ResponseEntity<>("Cash solo permite 1 pago", HttpStatus.FORBIDDEN);
            }
        }

        if (paymentRepository.findByName(paymentPostDTO.getName()) != null) {
            return new ResponseEntity<>("Ya existe ese tipo de pago", HttpStatus.FORBIDDEN);
        }
        Payment payment = new Payment(paymentPostDTO.getName(),paymentPostDTO.getPayments());
        paymentRepository.save(payment);

        return new ResponseEntity<>("Metodo de pago creado",HttpStatus.CREATED); //si pasó los anteriores requisitos, lo crea, lo guarda y envia un mensaje 201 creado
    }

    @Override
    public ResponseEntity<Object> updatePayment(PaymentPostDTO paymentPostDTO, Long id) {
        Optional<Payment> paymentAct = paymentRepository.findById(id); //no pongo el orElsenull (si pongo el orElseNull saco el optional)
        if (paymentAct == null) {
            return new ResponseEntity<>("No existe ese producto", HttpStatus.FORBIDDEN);
        }
        paymentAct.get().setName(paymentPostDTO.getName());
        paymentAct.get().setPayment(paymentPostDTO.getPayments());
        paymentRepository.save(paymentAct.get());

        return new ResponseEntity<>("Metodo de pago actualizado", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> patchPayment(PaymentPostDTO paymentPostDTO, Long id) {
        Payment paymentAct = paymentRepository.findById(id).orElse(null);

        if(paymentAct == null) {
            return new ResponseEntity<>("No encontrado", HttpStatus.FORBIDDEN);
        }
        if (paymentPostDTO.getName().equals("Debit")){
            if (paymentPostDTO.getPayments().size()>1){
                return new ResponseEntity<>("Debito solo permite 1 pago", HttpStatus.FORBIDDEN);
            }
            if (paymentPostDTO.getPayments().get(0)!=1){
                return new ResponseEntity<>("Debito solo permite 1 pago", HttpStatus.FORBIDDEN);
            }
        }
        if (paymentPostDTO.getName().equals("Cash")){
            if (paymentPostDTO.getPayments().size()>1){
                return new ResponseEntity<>("Cash solo permite 1 pago", HttpStatus.FORBIDDEN);
            }
            if (paymentPostDTO.getPayments().get(0)!=1){
                return new ResponseEntity<>("Cash solo permite 1 pago", HttpStatus.FORBIDDEN);
            }
        }
        if (paymentPostDTO.getName() != null){
            paymentAct.setName(paymentPostDTO.getName());

        }

        if (paymentPostDTO.getPayments() != null) {
            paymentAct.setPayment(paymentPostDTO.getPayments());
        }

        paymentRepository.save(paymentAct);
        return new ResponseEntity<>("Metodo de pago  actualizado", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> deletePayment(Long id) {
        Payment paymentDelete = paymentRepository.findById(id).orElse(null); //primero verificar que el prod a borrar no sea nulo
        // Set<PurchaseOrder> purchaseOrdersList = productoABorrar.getPurchaseOrders(); //La lista está ordenada con objs repetidos; el set viene desordenado y sin repetir datos
            if (paymentDelete == null) {
            return new ResponseEntity<>("No existe", HttpStatus.FORBIDDEN);
        }
        //Primero borrar el asociado:
        Set<Invoice> invoicesList = paymentDelete.getInvoices(); //La lista está ordenada con objs repetidos; el set viene desordenado y sin repetir datos
        invoiceRepository.deleteAll(invoicesList);
        paymentRepository.deleteById(paymentDelete.getId());

        return new ResponseEntity<>("Metodo de pago borrado", HttpStatus.OK);
    }
}
