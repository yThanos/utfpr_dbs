package dev.fraporti.utfpr_dbs.service;

import dev.fraporti.utfpr_dbs.model.Funcionario;
import dev.fraporti.utfpr_dbs.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Funcionario findMostWellPayed() {
        return this.repository.findFirstByOrderBySalarioDesc().orElse(null);
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

    public void updateSalary(int percentage) {
        this.repository.riseSalary(percentage);
    }

    public List<Funcionario> findWithoutDependentsByDepartment(String dep) {
        return this.repository.findWithoutDependentsByDepartment(dep);
    }

    public void updateEmployeeDepartment(Long oldDep, Long newDep) {
        this.repository.updateEmployeeDepartment(oldDep, newDep);
    }

    public void deleteByDepartment(Long dep) {
        this.repository.deleteByDepartment(dep);
    }
}
