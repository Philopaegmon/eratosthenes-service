package me.philopaegmon.eratosthenes_service.model.dto.author;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AuthorDto {
    private String firstName;
    private String lastName;
    private Set<BookDto> books;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder(toBuilder = true)
    public static class BookDto {
        private String name;
    }
}
