package dev.fraporti.utfpr_dbs.model;

import dev.fraporti.utfpr_dbs.util.DateUtil;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.ZonedDateTime;

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

    @Column(name = "data_cadastro")
    private ZonedDateTime dataCad;

    @Column(name = "data_update")
    private ZonedDateTime dataUpd;

    @Version
    @Column(name = "version")
    private Long version;

    @PrePersist
    public void prePersist() {
        this.dataCad = DateUtil.now();
        this.dataUpd = DateUtil.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.dataUpd = DateUtil.now();
    }
}
