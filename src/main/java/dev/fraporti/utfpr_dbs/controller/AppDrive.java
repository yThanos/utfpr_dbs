package dev.fraporti.utfpr_dbs.controller;

import dev.fraporti.utfpr_dbs.model.Departamento;
import dev.fraporti.utfpr_dbs.model.Funcionario;
import dev.fraporti.utfpr_dbs.service.DepartamentoService;
import dev.fraporti.utfpr_dbs.service.FuncionarioService;
import dev.fraporti.utfpr_dbs.service.TestRunner;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vitor.rosmann on 03/07/2025
 */
@Component
@RequiredArgsConstructor
public class AppDrive {
    private final TestRunner testRunner;

    @PostConstruct
    public void test() {
        this.testRunner.test();
    }
}
