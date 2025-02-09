package net.faris.inventoryservice.repository;

import net.faris.inventoryservice.entities.Product;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, String> {






}
