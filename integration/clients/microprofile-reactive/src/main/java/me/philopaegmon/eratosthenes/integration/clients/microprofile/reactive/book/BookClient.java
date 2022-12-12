package me.philopaegmon.eratosthenes.integration.clients.microprofile.reactive.book;

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
import me.philopaegmon.eratosthenes.integration.dto.author.AuthorDto.BookDto;
import me.philopaegmon.eratosthenes.integration.dto.book.SaveBookDto;
import me.philopaegmon.eratosthenes.integration.dto.book.UpdateBookDto;

@RegisterRestClient
@Path("/books")
public interface BookClient {
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Uni<BookDto> getBookById(@PathParam(value = "id") Long id);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Uni<BookDto> saveBook(SaveBookDto saveBookDto);

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Uni<BookDto> updateBook(@PathParam(value = "id") Long id, UpdateBookDto updateBookDto);

    @DELETE
    @Path("/{id}")
    Uni<Void> deleteBook(@PathParam(value = "id") Long id);
}
