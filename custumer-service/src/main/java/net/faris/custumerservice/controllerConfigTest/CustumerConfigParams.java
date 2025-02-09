package net.faris.custumerservice.controllerConfigTest;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "custumer.params")
public record CustumerConfigParams(int x, int y) {

}
