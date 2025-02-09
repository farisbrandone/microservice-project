package net.faris.custumerservice.controllerConfigTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class ConfigTestRestController {
    @Value("${global.params.p1}") /*injection des valeur obtenue après connexion au demarage vers le microservice config-servise */
    private String p1;

    @Value("${global.params.p2}")
    private String p2;

    @Autowired
    private CustumerConfigParams custumerConfigParams;

    @GetMapping("/test1") /*le test de cet url permet d'avoir la preuve qu'au demarrage il a contacter le config-service*/
    public Map<String, String> configTest() {
        return Map.of("p1", p1, "p2", p2);
    }
    @GetMapping("/test2") /*le test de cet url permet d'avoir la preuve qu'au demarrage il a contacter le config-service*/
    public CustumerConfigParams configTest2() {
        return custumerConfigParams;
    }

}
