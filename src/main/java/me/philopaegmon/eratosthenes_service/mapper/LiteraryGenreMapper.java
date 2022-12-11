package me.philopaegmon.eratosthenes_service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import me.philopaegmon.eratosthenes_service.model.LiteraryGenre;
import me.philopaegmon.eratosthenes_service.model.dto.LiteraryGenreEntryDto;

@Mapper(
    componentModel = "cdi",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface LiteraryGenreMapper {
    @Mapping(target="value", source = "name")
    LiteraryGenreEntryDto toLiteraryGenreEntryDto(LiteraryGenre literaryGenre);

    default List<LiteraryGenreEntryDto> toLiteraryGenreEntryDtoList(List<LiteraryGenre> literaryGenreList) {
        return literaryGenreList.stream()
            .map(this::toLiteraryGenreEntryDto)
            .collect(Collectors.toList());
    }
}
