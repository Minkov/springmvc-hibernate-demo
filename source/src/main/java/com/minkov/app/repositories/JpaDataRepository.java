package com.minkov.app.repositories;

import com.minkov.app.entities.base.DbEntity;
import com.minkov.app.repositories.base.DataRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class JpaDataRepository<T extends DbEntity> implements DataRepository<T> {

    private final EntityManagerFactory entityManagerFactory;
    private final Class<T> klass;

    public JpaDataRepository(EntityManagerFactory entityManagerFactory, Class<T> klass) {
        this.entityManagerFactory = entityManagerFactory;
        this.klass = klass;
    }

    @Override
    public List<T> listAll() {
        EntityManager manager = entityManagerFactory.createEntityManager();

        CriteriaBuilder builder = manager.getCriteriaBuilder();

        CriteriaQuery<T> criteriaQuery =
                builder.createQuery(klass);

        criteriaQuery.from(klass);

        List<T> entities = manager.createQuery(criteriaQuery)
                .getResultList();

        manager.close();
        return entities;
    }

    @Override
    public T find(long id) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        T entity = manager.find(klass, id);
        manager.close();
        return entity;
    }

    @Override
    public void add(T entity) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(entity);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void delete(T entity) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        if (!manager.contains(entity)) {
            entity = manager.merge(entity);
        }

        manager.getTransaction().begin();
        manager.remove(entity);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void delete(long id) {
        delete(find(id));
    }

    @Override
    public void update(T entity) {
        EntityManager manager = entityManagerFactory.createEntityManager();
        if (!manager.contains(entity)) {
            entity = manager.merge(entity);
        }

        manager.getTransaction().begin();
        manager.persist(entity);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void update(long id, T entity) {
        entity.setId(id);
        update(entity);
    }
}
