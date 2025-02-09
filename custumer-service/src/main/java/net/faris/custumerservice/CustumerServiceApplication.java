package net.faris.custumerservice;

import net.faris.custumerservice.controllerConfigTest.CustumerConfigParams;
import net.faris.custumerservice.entities.Custumer;
import net.faris.custumerservice.repository.CustumerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(CustumerConfigParams.class)
public class CustumerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustumerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustumerRepository custumerRepository){
        return args -> {
            custumerRepository.save(new Custumer("Mohamed", "med@gmail.com")
            );

            custumerRepository.save(new Custumer("Imane", "imane@gmail.com")

            );
            custumerRepository.save(new Custumer("Yassine", "yassine@gmail.com")

            );
            custumerRepository.findAll().forEach(custumer -> {
                System.out.println("=====================");
                System.out.println(custumer.getId());
                System.out.println(custumer.getEmail());
                System.out.println(custumer.getName());
                System.out.println("=====================");
            });
        };
    }

}
