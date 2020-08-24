package com.vmware.tanzu.car.swagger;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * ConfigurationProperties that load configuration of keys car.swagger
 *
 * @since JDK 11
 */
@Configuration
@ConfigurationProperties(prefix = "car.swagger")
@Data
public class SwaggerProperties {

    private String title;
    private String description;
    private String version;
    private String termsOfServiceUrl;
    private String license;
    private String licenseUrl;
    private Contact contact = new Contact();

    @Data
    public class Contact {
        private String name;
        private String url;
        private String email;
    }

}