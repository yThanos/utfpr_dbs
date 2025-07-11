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
public class Funcionario extends BaseEntity {
    @Column(name = "nome")
    private String nome;

    @Column(name = "qtd_dependentes")
    private Integer qtdDependentes;

    @Column(name = "salario")
    private Double salario;

    @Column(name = "cargo")
    private String cargo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cod_departamento")
    private Departamento departamento;
}
