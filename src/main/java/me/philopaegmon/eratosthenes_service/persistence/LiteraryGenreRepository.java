package me.philopaegmon.eratosthenes_service.persistence;

import java.util.List;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import io.smallrye.mutiny.Uni;
import me.philopaegmon.eratosthenes_service.model.LiteraryGenre;

@ApplicationScoped
public class LiteraryGenreRepository implements PanacheRepository<LiteraryGenre> {
    public Uni<List<LiteraryGenre>> findLiteraryGenresByIds(Set<Long> literaryGenreIds) {
        return find("#LiteraryGenre.getByIds", Parameters.with("ids", literaryGenreIds)).list();
    }

    public Uni<List<LiteraryGenre>> getLiteraryGenres() {
        return listAll();
    }
}
