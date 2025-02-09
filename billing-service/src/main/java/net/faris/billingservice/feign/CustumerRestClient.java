package net.faris.billingservice.feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.faris.billingservice.model.Custumer;
import net.faris.billingservice.model.Product;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "custumer-service")
public interface CustumerRestClient {
    @GetMapping("/api/custumers/{id}")
    @CircuitBreaker(name = "custumerServiceCB", fallbackMethod = "getDefaultCustumer")
    Custumer findCustumerById(@PathVariable Long id);

    @GetMapping("/api/custumers")
    @CircuitBreaker(name = "custumerServiceCB", fallbackMethod = "getDefaultCustumers")
    PagedModel<Custumer> getAllCustumers();

    default Custumer getDefaultCustumer(Long id, Exception e) {
        return new Custumer(id, "Default Name", "Default Email");
    }

    default PagedModel<Custumer>  getDefaultCustumers(Exception e) {
        return PagedModel.empty();
    }
}
