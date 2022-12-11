package me.philopaegmon.eratosthenes_service.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class LanguageEntryDto {
    private long id;
    private String value;
}
