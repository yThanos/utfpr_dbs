package dev.fraporti.utfpr_dbs.repository;

import dev.fraporti.utfpr_dbs.model.Departamento;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author vitor.rosmann on 03/07/2025
 */
@Repository
public interface DepartamentoRepository extends BaseRepository<Departamento> {
    Optional<Departamento> findFirstByOrderByDataCadAsc();
}
