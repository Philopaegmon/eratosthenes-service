package me.philopaegmon.eratosthenes_service.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.jboss.resteasy.reactive.RestResponse;

import io.smallrye.mutiny.Uni;
import me.philopaegmon.eratosthenes.integration.dto.LiteraryGenreEntryDto;
import me.philopaegmon.eratosthenes_service.service.LiteraryGenreService;

@Path("/genres")
public class LiteraryGenreResource {

    @Inject
    LiteraryGenreService literaryGenreService;

    @GET
    @Path("/")
    public Uni<RestResponse<List<LiteraryGenreEntryDto>>> getLiteraryGenres() {
        return literaryGenreService.getLiteraryGenres()
            .map(RestResponse::ok);
    }
}
