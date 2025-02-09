package net.faris.inventoryservice;

import net.faris.inventoryservice.entities.Product;
import net.faris.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository) {
           return args -> {
			   productRepository.save(new Product(UUID.randomUUID().toString(),"computer", 3200, 50));
			   productRepository.save(new Product(UUID.randomUUID().toString(),"smartphone", 5800, 1100));
			   productRepository.save(new Product(UUID.randomUUID().toString(),"printer", 2548, 250));
		   productRepository.findAll().forEach(product ->{System.out.println(product.toString());

		   });
		   };
	}



}
