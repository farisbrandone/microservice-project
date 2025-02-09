package net.faris.custumerservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "all", types = Custumer.class)
public interface CustumerProjection {
    String getName();
    String getEmail();
}
