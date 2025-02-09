package net.faris.billingservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import net.faris.billingservice.model.Product;

@Entity
public class ProductItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Bill bill;
    private int quantity;
    private double unitPrice;
    @Transient
    private Product product;

    public ProductItem() {
    }

    public ProductItem(String productId, Bill bill, int quantity, double unitPrice) {
        this.id = id;
        this.productId = productId;
        this.bill = bill;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public Long getId() {
        return id;
    }

    public String getProductId() {
        return productId;
    }

    public Bill getBill() {
        return bill;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
