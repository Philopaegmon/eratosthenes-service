package me.philopaegmon.eratosthenes_service.persistence;

public interface Persistable<I> {
    I getId();
    void setId(I id);
}
