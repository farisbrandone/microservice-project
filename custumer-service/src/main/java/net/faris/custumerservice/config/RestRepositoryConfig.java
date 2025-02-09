package net.faris.custumerservice.config;

import net.faris.custumerservice.entities.Custumer;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;


@Configuration
public class RestRepositoryConfig implements RepositoryRestConfigurer {
     @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry registry) {
         config.exposeIdsFor(Custumer.class);/*on autoerise spring data rest de sérialiser également l'id*/
     }

}
