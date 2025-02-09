package net.faris.billingservice.entities;

import jakarta.persistence.*;
import net.faris.billingservice.model.Custumer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billingDate;
    private Long custumerId;
    @OneToMany(mappedBy ="bill" )
    private List<ProductItem> productItems=new ArrayList<>();
    @Transient private Custumer custumer;
    public Bill() {
    }

    public Bill( Date billingDate, Long custumerId) {

        this.billingDate = billingDate;
        this.custumerId = custumerId;

    }

    public Long getId() {
        return id;
    }

    public Date getBillingDate() {
        return billingDate;
    }

    public Long getCustumerId() {
        return custumerId;
    }

    public List<ProductItem> getProductItems() {
        return productItems;
    }

    public Custumer getCustumer() {
        return custumer;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustumer(Custumer custumer) {
        this.custumer = custumer;
    }

    public void setProductItems(List<ProductItem> productItems) {
        this.productItems = productItems;
    }

    public void setCustumerId(Long custumerId) {
        this.custumerId = custumerId;
    }

    public void setBillingDate(Date billingDate) {
        this.billingDate = billingDate;
    }
}
