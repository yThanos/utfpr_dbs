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

    public DepartamentoService(DepartamentoRepository repository) {
        super(repository);
    }

    public Departamento findFirst() {
        return this.repository.findFirstByOrderByDataCadAsc().orElse(null);
    }
}
