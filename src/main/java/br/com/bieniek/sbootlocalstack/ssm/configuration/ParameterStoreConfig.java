package br.com.bieniek.sbootlocalstack.ssm.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
public class ParameterStoreConfig {

    @Getter
    @Setter
    @Value("${helloWorld}")
    private String helloWorld;


}
