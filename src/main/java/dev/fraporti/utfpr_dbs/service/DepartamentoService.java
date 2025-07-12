package dev.fraporti.utfpr_dbs.service;

import dev.fraporti.utfpr_dbs.model.Departamento;
import dev.fraporti.utfpr_dbs.repository.DepartamentoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author vitor.rosmann on 03/07/2025
 */
@Service
public class DepartamentoService extends EntityService<Departamento, DepartamentoRepository> {

    private final DepartamentoRepository departamentoRepository;

    public DepartamentoService(DepartamentoRepository repository,
                               DepartamentoRepository departamentoRepository) {
        super(repository);
        this.departamentoRepository = departamentoRepository;
    }

    public Optional<Departamento> findFirst() {
        return departamentoRepository.findFirstByOrderByDataCadAsc();
    }
}
