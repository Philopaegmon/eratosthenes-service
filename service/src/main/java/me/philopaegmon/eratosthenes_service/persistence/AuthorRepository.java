package me.philopaegmon.eratosthenes_service.persistence;

import java.util.List;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import io.smallrye.mutiny.Uni;
import me.philopaegmon.eratosthenes_service.model.Author;

@ApplicationScoped
public class AuthorRepository implements PanacheRepository<Author> {
    public Uni<Author> findAuthorById(Long id) {
        return findById(id);
    }

    public Uni<List<Author>> findAuthorsByIds(Set<Long> authorIds) {
        return find("#Author.getByIds", Parameters.with("ids", authorIds))
            .list();
    }

    public Uni<Author> saveAuthor(Author author) {
        return persist(author);
    }
}
