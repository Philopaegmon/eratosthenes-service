package me.philopaegmon.eratosthenes_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class BookDto {
    private String name;
}
