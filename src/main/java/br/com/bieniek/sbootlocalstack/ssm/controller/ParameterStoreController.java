package br.com.bieniek.sbootlocalstack.ssm.controller;

import br.com.bieniek.sbootlocalstack.ssm.configuration.ParameterStoreConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class ParameterStoreController {

    private final ParameterStoreConfig config;

    @GetMapping("/parameterStoreConfiguration")
    public String configuration() {
        return config.getHelloWorld();
    }
}
