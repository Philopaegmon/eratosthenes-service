package me.philopaegmon.eratosthenes_service.persistence;

import io.smallrye.mutiny.Uni;

public interface Repository<E, I> {
    Uni<E> findById(I id);
    Uni<E> save(E entity);
    Uni<Void> delete(E entity);
    Uni<Void> deleteById(I id);
}
