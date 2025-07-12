package dev.fraporti.utfpr_dbs.service;

import dev.fraporti.utfpr_dbs.model.Funcionario;
import dev.fraporti.utfpr_dbs.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author vitor.rosmann on 03/07/2025
 */
@Service
public class FuncionarioService extends EntityService<Funcionario, FuncionarioRepository> {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository repository,
                              FuncionarioRepository funcionarioRepository) {
        super(repository);
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> findByNomeAndQtdDependentes(String nome, int qtdDeps) {
        return this.repository.findByNomeAndQtdDependentes(nome, qtdDeps);
    }

    public List<Funcionario> findByDepartamento(int codDep) {
        return funcionarioRepository.findByDepartamento_Codigo(codDep);
    }

    public Optional<Funcionario> findMostWellPayed() {
        return this.repository.findFirstByOrderBySalarioDesc();
    }

    public List<Funcionario> findTop3BySalary() {
        return this.repository.findTop3ByOrderBySalarioDesc();
    }

    public List<Funcionario> findAllWithNoDependents() {
        return this.repository.findAllWithNoDependents();
    }

    public List<Funcionario> findAllWithSalaryHigherThan(double valor) {
        return this.repository.findAllWithSalaryHigherThan(valor);
    }

    public List<Funcionario> nativeFindAllWithSalaryHigherThan(double valor) {
        return this.repository.nativeFindAllWithSalaryHigherThan(valor);
    }

    public List<Funcionario> byQtdDependentes(int qtd) {
        return this.repository.byQtdDependentes(qtd);
    }

    public List<Funcionario> byNameLike(String name) {
        return this.repository.byNameLike(name);
    }
}
