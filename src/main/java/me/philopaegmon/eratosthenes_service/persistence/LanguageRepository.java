package me.philopaegmon.eratosthenes_service.persistence;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;
import me.philopaegmon.eratosthenes_service.model.Language;

@ApplicationScoped
public class LanguageRepository implements PanacheRepository<Language> {

    public Uni<Language> findLanguageById(Long id) {
        return findById(id);
    }

    public Uni<List<Language>> listAllLanguages() {
        return listAll();
    }
    
}
