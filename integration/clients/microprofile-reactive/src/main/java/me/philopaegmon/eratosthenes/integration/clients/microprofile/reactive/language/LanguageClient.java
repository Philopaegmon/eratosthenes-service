package me.philopaegmon.eratosthenes.integration.clients.microprofile.reactive.language;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.smallrye.mutiny.Uni;
import me.philopaegmon.eratosthenes.integration.dto.LanguageEntryDto;

@RegisterRestClient
@Path("/languages")
public interface LanguageClient {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Uni<List<LanguageEntryDto>> getAllLanguages();
}
