package me.philopaegmon.eratosthenes_service.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.smallrye.mutiny.Uni;
import me.philopaegmon.eratosthenes_service.mapper.LiteraryGenreMapper;
import me.philopaegmon.eratosthenes_service.model.dto.LiteraryGenreEntryDto;
import me.philopaegmon.eratosthenes_service.persistence.LiteraryGenreRepository;

@ApplicationScoped
public class LiteraryGenreService {
    
    @Inject
    LiteraryGenreRepository literaryGenreRepository;

    @Inject
    LiteraryGenreMapper literaryGenreMapper;

    public Uni<List<LiteraryGenreEntryDto>> getLiteraryGenres() {
        return literaryGenreRepository.getLiteraryGenres()
            .map(literaryGenreMapper::toLiteraryGenreEntryDtoList);
    }
}
