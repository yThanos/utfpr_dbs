package dev.fraporti.utfpr_dbs.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vitor.rosmann on 03/07/2025
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "departamento")
public class Departamento extends BaseEntity {
    @Column(name = "nome")
    private String nome;

    @ToString.Exclude
    @OneToMany(mappedBy = "departamento", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Funcionario> funcionarios;
}
