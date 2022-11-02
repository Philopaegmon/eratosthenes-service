package me.philopaegmon.eratosthenes_service.persistence;

import javax.enterprise.context.ApplicationScoped;

import me.philopaegmon.eratosthenes_service.model.Book;

@ApplicationScoped
public class BookRepository extends RepositoryBase<Book, Long> {

    @Override
    protected Class<Book> getEntityClass() {
        return Book.class;
    }
    
}
