package net.faris.billingservice;

import net.faris.billingservice.entities.Bill;
import net.faris.billingservice.entities.ProductItem;
import net.faris.billingservice.feign.CustumerRestClient;
import net.faris.billingservice.feign.ProductRestClient;
import net.faris.billingservice.model.Custumer;
import net.faris.billingservice.model.Product;
import net.faris.billingservice.repository.BillRepository;
import net.faris.billingservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(BillRepository billRepository, ProductItemRepository productItemRepository, CustumerRestClient custumerRestClient, ProductRestClient productRestClient) {
	return args -> {
		Collection<Custumer> custumers=custumerRestClient.getAllCustumers().getContent();
		Collection<Product> products=productRestClient.getAllProducts().getContent();
		custumers.forEach(custumer->{
			Bill bill=new Bill(new Date(), custumer.getId());
			billRepository.save(bill);
			products.forEach(product->{
				ProductItem productItem=new ProductItem( product.getId(),bill, new Random().nextInt(10), product.getPrice());
				productItemRepository.save(productItem);
			});

		});
	};
	}

}
