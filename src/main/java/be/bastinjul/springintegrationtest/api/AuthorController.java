package be.bastinjul.springintegrationtest.api;

import be.bastinjul.springintegrationtest.entities.Author;
import be.bastinjul.springintegrationtest.integration.gateways.SaveAuthorGateway;
import be.bastinjul.springintegrationtest.repositories.AuthorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/authors")
public class AuthorController {

    private final AuthorRepository authorRepository;
    private final SaveAuthorGateway authorGateway;

    public AuthorController(AuthorRepository authorRepository, SaveAuthorGateway authorGateway) {
        this.authorRepository = authorRepository;
        this.authorGateway = authorGateway;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Author createAuthor(@RequestBody Author author) {
        return authorGateway.saveAuthor(author);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Author getAuthor(@PathVariable(value = "id") Long id) {
        return authorRepository.findById(id).orElse(null);
    }
}
