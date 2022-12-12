package me.philopaegmon.eratosthenes_service.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.smallrye.mutiny.Uni;
import me.philopaegmon.eratosthenes.integration.dto.LanguageEntryDto;
import me.philopaegmon.eratosthenes_service.service.LanguageService;

@Path("/languages")
public class LanguageResource {
    
    @Inject
    LanguageService languageService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<List<LanguageEntryDto>> getAllLanguages() {
        return languageService.getAllLanguages();
    }
}
