package br.com.bieniek.sbootlocalstack.secretsmanager.controller;

import br.com.bieniek.sbootlocalstack.secretsmanager.configuration.SecretsManagerConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class SecretsManagerController {

    private final SecretsManagerConfiguration config;

    @GetMapping("/secretsManagerConfiguration")
    public String configuration() {
        return String.format("%s - %s - %s", config.getValor1(), config.getValor2(), config.getValor3());
    }
}
