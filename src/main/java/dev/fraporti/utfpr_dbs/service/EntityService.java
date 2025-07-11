package dev.fraporti.utfpr_dbs.service;

import dev.fraporti.utfpr_dbs.model.BaseEntity;
import dev.fraporti.utfpr_dbs.repository.BaseRepository;
import jakarta.persistence.EntityNotFoundException;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author vitor.rosmann on 03/07/2025
 */
public abstract class EntityService<T extends BaseEntity> {
    protected final BaseRepository<T> repository;
    protected final Class<T> clazz;

    @SuppressWarnings("unchecked")
    public EntityService(BaseRepository<T> repository) {
        this.repository = repository;
        this.clazz = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public T save(T entity){
        return this.repository.save(entity);
    }

    public List<T> save(Iterable<T> entities){
        return this.repository.saveAll(entities);
    }

    public List<T> findAll() {
        return this.repository.findAll();
    }

    public T findByIdOrNull(Long id){
        return this.repository.findById(id).orElse(null);
    }

    public T findByIdOrThrow(Long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(clazz.getSimpleName() + " com id " + id + " não encontrado!"));
    }

    public void deleteById(Long id){
        this.repository.deleteById(id);
    }
}
