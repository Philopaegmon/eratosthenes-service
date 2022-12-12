package me.philopaegmon.eratosthenes.integration.dto.book;

import java.time.LocalDate;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class SaveBookDto {
    private String name;
    private String isbn;
    private Set<Long> authorIds;
    private Set<Long> literaryGenresIds;
    private Long languageId;
    private LocalDate publicationDate;
}
