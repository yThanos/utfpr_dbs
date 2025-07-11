package dev.fraporti.utfpr_dbs.service;

import dev.fraporti.utfpr_dbs.model.Departamento;
import dev.fraporti.utfpr_dbs.repository.DepartamentoRepository;
import org.springframework.stereotype.Service;

/**
 * @author vitor.rosmann on 03/07/2025
 */
@Service
public class DepartamentoService extends EntityService<Departamento> {
    public DepartamentoService(DepartamentoRepository repository) {
        super(repository);
    }
}
