package br.com.bieniek.sbootlocalstack.secretsmanager.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@Getter
@Setter
public class SecretsManagerConfiguration {

    @Value("${valor1}")
    private String valor1;
    @Value("${valor2}")
    private String valor2;
    @Value("${valor3}")
    private String valor3;
}
