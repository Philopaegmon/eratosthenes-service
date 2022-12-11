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

import org.jboss.resteasy.reactive.RestResponse;

import io.smallrye.mutiny.Uni;
import me.philopaegmon.eratosthenes_service.model.dto.book.BookDto;
import me.philopaegmon.eratosthenes_service.model.dto.book.SaveBookDto;
import me.philopaegmon.eratosthenes_service.model.dto.book.UpdateBookDto;
import me.philopaegmon.eratosthenes_service.service.BookService;

@Path("/books")
public class BookResource {

    @Inject
    BookService bookService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<RestResponse<BookDto>> getBookById(@PathParam(value = "id") Long id) {
        return bookService.getBookById(id)
            .map(RestResponse::ok);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<RestResponse<BookDto>> saveBook(SaveBookDto saveBookDto) {
        return bookService.saveBook(saveBookDto)
            .map(RestResponse::ok);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<RestResponse<BookDto>> updateBook(@PathParam(value = "id") Long id, UpdateBookDto updateBookDto) {
        return bookService.updateBook(id, updateBookDto)
            .map(RestResponse::ok);
    }

    @DELETE
    @Path("/{id}")
    public Uni<Void> deleteBook(@PathParam(value = "id") Long id) {
        return bookService.deleteById(id);
    }
}