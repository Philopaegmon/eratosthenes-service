package me.philopaegmon.eratosthenes_service.persistence;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;
import me.philopaegmon.eratosthenes_service.model.Book;

@ApplicationScoped
public class BookRepository implements PanacheRepository<Book> {
    public Uni<Book> findBookById(Long id) {
        return findById(id);
    }

    public Uni<Book> saveBook(Book entity) {
        return persist(entity);
    }

    public Uni<Boolean> deleteBookById(Long id) {
        return deleteById(id);
    }
    
}
