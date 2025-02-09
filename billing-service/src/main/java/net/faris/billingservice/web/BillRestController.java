package net.faris.billingservice.web;

import net.faris.billingservice.entities.Bill;
import net.faris.billingservice.feign.CustumerRestClient;
import net.faris.billingservice.feign.ProductRestClient;
import net.faris.billingservice.repository.BillRepository;
import net.faris.billingservice.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {

       @Autowired
    private BillRepository billRepository;
       @Autowired
    private ProductItemRepository productItemRepository;
       @Autowired
    private CustumerRestClient custumerRestClient;
       @Autowired
    private ProductRestClient productRestClient;

       @GetMapping("/bills/{id}")
       public Bill getBill(@PathVariable Long id) {
           Bill bill = billRepository.findById(id).get();
           bill.setCustumer(custumerRestClient.findCustumerById(bill.getCustumerId()));
           bill.getProductItems().forEach(productItem -> {
               productItem.setProduct(productRestClient.getProductById(productItem.getProductId()));
           });
           return bill;
       }
}
