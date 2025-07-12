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


    public long test1() {
        Departamento d = new Departamento();
        d.setNome("P&D");
        d = departamentoService.save(d);

        final List<Funcionario> funcionarios = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Funcionario f = new Funcionario();
            f.setNome("Funcionario " + i);
            f.setDepartamento(d);
            f.setCargo("Analista de desenvolvimento");
            f.setSalario(1518.0 * (i+1));
            f.setQtdDependentes(i);
            funcionarios.add(f);
        }
        funcionarioService.save(funcionarios);

        return d.getCodigo();
    }

    @Transactional
    public void test2(long codigo){
        System.out.println(
                this.funcionarioService
                        .findByNomeAndQtdDependentes("Funcionario 1", 1)
        );

        final Departamento dep = this.departamentoService.findByIdOrThrow(codigo);
        for(Funcionario f: dep.getFuncionarios()){
            System.out.println(f);
        }

        System.out.println(this.departamentoService.findFirst());

        System.out.println(this.funcionarioService.findMostWellPayed());

        System.out.println(this.funcionarioService.findTop3BySalary());

        System.out.println(this.funcionarioService.findAllWithNoDependents());

        System.out.println(this.funcionarioService.findAllWithSalaryHigherThan(4000.0));

        System.out.println(this.funcionarioService.nativeFindAllWithSalaryHigherThan(5000.0));

        System.out.println(this.funcionarioService.byQtdDependentes(3));

        System.out.println(this.funcionarioService.byNameLike("o 4"));
    }
}
