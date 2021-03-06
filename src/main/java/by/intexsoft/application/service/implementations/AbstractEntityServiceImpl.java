package by.intexsoft.application.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import by.intexsoft.application.model.AbstractEntity;
import by.intexsoft.application.service.AbstractEntityService;

/**
 * Implementation of a {@link AbstractEntityService} which allows to perform
 * basic CRUD operations upon entities
 *
 * @param <T> - entity upon which basic CRUD operations will take place
 */
public abstract class AbstractEntityServiceImpl<T extends AbstractEntity> implements AbstractEntityService<T> {

    private final JpaRepository<T, Integer> repository;

    @Autowired
    public AbstractEntityServiceImpl(JpaRepository<T, Integer> repository) {
        this.repository = repository;
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public T findOne(int id) {
        return repository.findOne(id);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
