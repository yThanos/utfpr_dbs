package dev.fraporti.utfpr_dbs.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author vitor.rosmann on 03/07/2025
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "funcionario")
@NamedQuery(
        name = "Funcionario.byQtdDependentes",
        query = "FROM Funcionario f WHERE f.qtdDependentes = ?1"
)
@NamedNativeQuery(
        name = "Funcionario.byNameLike",
        query = "SELECT * FROM funcionario WHERE nome LIKE CONCAT('%', ?1, '%')",
        resultClass = Funcionario.class
)
public class Funcionario extends BaseEntity {
    @Column(name = "nome")
    private String nome;

    @Column(name = "qtd_dependentes")
    private Integer qtdDependentes;

    @Column(name = "salario")
    private Double salario;

    @Column(name = "cargo")
    private String cargo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_departamento")
    private Departamento departamento;
}
