package be.bastinjul.springintegrationtest.api;

import be.bastinjul.springintegrationtest.entities.Book;
import be.bastinjul.springintegrationtest.integration.gateways.ObjectSaverGateway;
import be.bastinjul.springintegrationtest.repositories.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/books")
public class BookController {

    private final ObjectSaverGateway objectSaverGateway;
    private final BookRepository bookRepository;

    public BookController(ObjectSaverGateway objectSaverGateway, BookRepository bookRepository) {
        this.objectSaverGateway = objectSaverGateway;
        this.bookRepository = bookRepository;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Book createBook(@RequestBody Book book) {
        return (Book) objectSaverGateway.saveObject(book);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Book getBook(@PathVariable(value = "id") Long id) {
        return bookRepository.getReferenceById(id);
    }
}
