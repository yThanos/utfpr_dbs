package dev.fraporti.utfpr_dbs.service;

import dev.fraporti.utfpr_dbs.model.Departamento;
import dev.fraporti.utfpr_dbs.model.Funcionario;
import dev.fraporti.utfpr_dbs.repository.DepartamentoRepository;
import dev.fraporti.utfpr_dbs.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author vitor.rosmann on 03/07/2025
 */
@Service
public class DepartamentoService extends EntityService<Departamento, DepartamentoRepository> {
    private final FuncionarioRepository funcionarioRepository;

    public DepartamentoService(DepartamentoRepository repository, FuncionarioRepository funcionarioRepository) {
        super(repository);
        this.funcionarioRepository = funcionarioRepository;
    }

    public Departamento findFirst() {
        return this.repository.findFirstByOrderByDataCadAsc().orElse(null);
    }

    @Transactional
    public void saveDepartmentAndEmployee(Departamento dep, Funcionario func) {
        Departamento savedDep = this.repository.save(dep);

        func.setDepartamento(savedDep);

        funcionarioRepository.save(func);
    }
}
