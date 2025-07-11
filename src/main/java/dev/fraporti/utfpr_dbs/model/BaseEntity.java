package dev.fraporti.utfpr_dbs.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author vitor.rosmann on 03/07/2025
 */
@Getter
@Setter
@ToString
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
}
