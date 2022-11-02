package me.philopaegmon.eratosthenes_service.persistence;

import java.util.Objects;

import javax.inject.Inject;

import org.hibernate.reactive.mutiny.Mutiny;

import io.smallrye.mutiny.Uni;

public abstract class RepositoryBase<E extends Persistable<I>, I> implements Repository<E, I> {
    @Inject
    Mutiny.SessionFactory sf; 

    protected abstract Class<E> getEntityClass();

    @Override
    public Uni<E> findById(I id) {
        return sf.withTransaction(session -> session.find(getEntityClass(), id));
    }

    @Override
    public Uni<E> save(E entity) {
        if (Objects.nonNull(entity.getId())) {
            return sf.withTransaction(session -> session.persist(entity))
            .replaceWith(entity);
        }
        return sf.withTransaction(session -> session.merge(entity));        
    }

    @Override
    public Uni<Void> delete(E entity) {
        return findById(entity.getId())
            .flatMap(entity1 -> sf.withTransaction(session -> session.remove(entity1)));
    }

    @Override
    public Uni<Void> deleteById(I id) {
        return findById(id)
            .flatMap(entity1 -> sf.withTransaction(session -> session.remove(entity1)));
    }
}
