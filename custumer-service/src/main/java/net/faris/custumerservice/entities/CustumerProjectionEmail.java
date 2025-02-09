


package net.faris.custumerservice.entities;

import net.faris.custumerservice.entities.Custumer;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "email", types = Custumer.class)
public interface CustumerProjectionEmail  {
    String getEmail();
}

