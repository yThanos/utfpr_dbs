package dev.fraporti.utfpr_dbs.service;

import dev.fraporti.utfpr_dbs.model.Funcionario;
import dev.fraporti.utfpr_dbs.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

/**
 * @author vitor.rosmann on 03/07/2025
 */
@Service
public class FuncionarioService extends EntityService<Funcionario> {
    public FuncionarioService(FuncionarioRepository repository) {
        super(repository);
    }
}
