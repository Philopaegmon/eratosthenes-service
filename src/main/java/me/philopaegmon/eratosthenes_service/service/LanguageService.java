package me.philopaegmon.eratosthenes_service.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.smallrye.mutiny.Uni;
import me.philopaegmon.eratosthenes_service.mapper.LanguageMapper;
import me.philopaegmon.eratosthenes_service.model.dto.LanguageEntryDto;
import me.philopaegmon.eratosthenes_service.persistence.LanguageRepository;

@ApplicationScoped
public class LanguageService {

    @Inject
    LanguageRepository languageRepository;

    @Inject
    LanguageMapper languageMapper;

    public Uni<List<LanguageEntryDto>> getAllLanguages() {
        return languageRepository.listAllLanguages()
            .map(languages -> 
                languages.stream()
                    .map(languageMapper::toLanguageEntryDto)
                    .toList()
            );
    }
}
