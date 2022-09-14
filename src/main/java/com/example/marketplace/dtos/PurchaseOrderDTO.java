package com.example.marketplace.dtos;

import com.example.marketplace.models.PurchaseOrder;

public class PurchaseOrderDTO {
    private String nameProduct;
    private int quantity;
    private String price;


    public PurchaseOrderDTO(PurchaseOrder purchaseOrder) {

        this.nameProduct=purchaseOrder.getProduct().getName();
        this.quantity = purchaseOrder.getQuantity();
        this.price = "$"+purchaseOrder.getPrice();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }
}
