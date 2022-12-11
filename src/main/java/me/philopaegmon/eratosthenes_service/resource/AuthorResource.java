package me.philopaegmon.eratosthenes_service.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.smallrye.mutiny.Uni;
import me.philopaegmon.eratosthenes_service.model.dto.author.AuthorDto;
import me.philopaegmon.eratosthenes_service.model.dto.author.CreateAuthorDto;
import me.philopaegmon.eratosthenes_service.model.dto.author.UpdateAuthorDto;
import me.philopaegmon.eratosthenes_service.service.AuthorService;

@Path("/authors")
public class AuthorResource {

    @Inject
    AuthorService authorService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<AuthorDto> getAuthorById(@PathParam("id") Long id) {
        return authorService.getAuthorById(id); 
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<AuthorDto> createAuthor(CreateAuthorDto createAuthorDto) {
        return authorService.createAuthor(createAuthorDto);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<AuthorDto> updateAuthor(@PathParam("id") Long id, UpdateAuthorDto updateAuthorDto) {
        return authorService.updateAuthor(id, updateAuthorDto);
    }

    @DELETE
    @Path("/{id}")
    public Uni<Void> deleteAuthor(@PathParam("id") Long id) {
        return authorService.deleteAuthor(id);
    }
}
