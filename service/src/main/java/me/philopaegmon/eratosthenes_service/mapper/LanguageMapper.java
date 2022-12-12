package me.philopaegmon.eratosthenes_service.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import me.philopaegmon.eratosthenes.integration.dto.LanguageEntryDto;
import me.philopaegmon.eratosthenes_service.model.Language;

@Mapper(
    componentModel = "cdi",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface LanguageMapper {
    @Mapping(target="value", source = "name")
    LanguageEntryDto toLanguageEntryDto(Language language);   
}
