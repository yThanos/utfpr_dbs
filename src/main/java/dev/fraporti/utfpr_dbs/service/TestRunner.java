package dev.fraporti.utfpr_dbs.service;

import dev.fraporti.utfpr_dbs.model.Departamento;
import dev.fraporti.utfpr_dbs.model.Funcionario;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vitor.rosmann on 03/07/2025
 */
@Service
@RequiredArgsConstructor
public class TestRunner {
    private final DepartamentoService departamentoService;
    private final FuncionarioService funcionarioService;

    @Transactional
    public void test() {
        Departamento d = new Departamento();
        d.setNome("P&D");
        d = departamentoService.save(d);

        List<Funcionario> funcionarios = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Funcionario f = new Funcionario();
            f.setNome("Funcionario " + i);
            f.setDepartamento(d);
            f.setCargo("Analista de desenvolvimento");
            f.setSalario(1518.0 * i+1);
            f.setQtdDependentes(i);
            funcionarios.add(f);
        }
        funcionarios = funcionarioService.save(funcionarios);

        for (Funcionario f: funcionarios) {
            System.out.println(f);
        }
    }
}
