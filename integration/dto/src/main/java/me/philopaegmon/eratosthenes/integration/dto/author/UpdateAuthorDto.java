package me.philopaegmon.eratosthenes.integration.dto.author;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class UpdateAuthorDto {
    private String firstName;
    private String lastName;
}
