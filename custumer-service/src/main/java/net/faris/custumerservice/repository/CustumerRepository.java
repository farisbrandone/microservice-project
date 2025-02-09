package net.faris.custumerservice.repository;

import net.faris.custumerservice.entities.Custumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CustumerRepository extends JpaRepository<Custumer, Long> {
}
