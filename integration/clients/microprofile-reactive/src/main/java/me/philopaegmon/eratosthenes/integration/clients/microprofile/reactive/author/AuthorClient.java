package me.philopaegmon.eratosthenes.integration.clients.microprofile.reactive.author;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.smallrye.mutiny.Uni;
import me.philopaegmon.eratosthenes.integration.dto.author.AuthorDto;
import me.philopaegmon.eratosthenes.integration.dto.author.CreateAuthorDto;
import me.philopaegmon.eratosthenes.integration.dto.author.UpdateAuthorDto;

@RegisterRestClient
@Path("/authors")
public interface AuthorClient {
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<AuthorDto> getAuthorById(@PathParam("id") Long id);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Uni<AuthorDto> createAuthor(CreateAuthorDto createAuthorDto);

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Uni<AuthorDto> updateAuthor(@PathParam("id") Long id, UpdateAuthorDto updateAuthorDto);

    @DELETE
    @Path("/{id}")
    Uni<Void> deleteAuthor(@PathParam("id") Long id);
}
