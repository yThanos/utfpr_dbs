package dev.fraporti.utfpr_dbs.repository;

import dev.fraporti.utfpr_dbs.model.Funcionario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author vitor.rosmann on 03/07/2025
 */
@Repository
public interface FuncionarioRepository extends BaseRepository<Funcionario> {
    List<Funcionario> findByNomeAndQtdDependentes(String nome, Integer qtdDependentes);

    @Query("select f from Funcionario f where f.departamento.codigo = ?1")
    List<Funcionario> findByDepartamento_Codigo(long codigo);

    Optional<Funcionario> findFirstByOrderBySalarioDesc();
    List<Funcionario> findTop3ByOrderBySalarioDesc();

    @Query("select f from Funcionario f where f.qtdDependentes = 0 or f.qtdDependentes is null")
    List<Funcionario> findAllWithNoDependents();

    @Query("select f from Funcionario f where f.salario > :valor")
    List<Funcionario> findAllWithSalaryHigherThan(@Param("valor") double valor);

    @Query(value = "select f.* from Funcionario f where f.salario > ?1", nativeQuery = true)
    List<Funcionario> nativeFindAllWithSalaryHigherThan(double valor);

    @Query(name = "Funcionario.byQtdDependentes")
    List<Funcionario> byQtdDependentes(int qtd);

    @Query(name = "Funcionario.byNameLike", nativeQuery = true)
    List<Funcionario> byNameLike(String nome);
}
