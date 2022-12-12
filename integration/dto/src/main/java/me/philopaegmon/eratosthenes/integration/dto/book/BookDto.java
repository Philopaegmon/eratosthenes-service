package me.philopaegmon.eratosthenes.integration.dto.book;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class BookDto {
    private String name;
    private Set<AuthorDto> authors;

    @Data
    @AllArgsConstructor
    @Builder(toBuilder = true)
    public static class AuthorDto {
        private String firstName;
        private String lastName;
    }
}
