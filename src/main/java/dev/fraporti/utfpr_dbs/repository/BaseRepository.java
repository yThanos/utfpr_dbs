package dev.fraporti.utfpr_dbs.repository;

import dev.fraporti.utfpr_dbs.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author vitor.rosmann on 03/07/2025
 */
@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Long> {
}
