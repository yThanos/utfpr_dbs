package dev.fraporti.utfpr_dbs.controller;

import dev.fraporti.utfpr_dbs.service.TestRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author vitor.rosmann on 03/07/2025
 */
@Component
public class AppDriver {

    @Bean
    CommandLineRunner test(TestRunner testRunner) {
        return (arg) -> {
            long cod = testRunner.test1();
            testRunner.test2(cod);
            testRunner.test3();
        };
    }
}
