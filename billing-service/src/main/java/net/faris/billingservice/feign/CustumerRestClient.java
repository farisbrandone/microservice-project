package net.faris.billingservice.feign;

import net.faris.billingservice.model.Custumer;
import net.faris.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "custumer-service")
public interface CustumerRestClient {
    @GetMapping("/api/custumers/{id}")
     Custumer findCustumerById(@PathVariable Long id);

    @GetMapping("/api/custumers")
    PagedModel<Custumer> getAllCustumers();
}
