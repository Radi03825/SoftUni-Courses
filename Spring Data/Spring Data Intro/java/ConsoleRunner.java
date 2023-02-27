package main.java.com.example.springdemo;

import com.example.springdemo.models.Author;
import com.example.springdemo.models.Book;
import com.example.springdemo.repositories.AuthorRepository;
import com.example.springdemo.repositories.BookRepository;
import com.example.springdemo.services.AuthorServiceImpl;
import com.example.springdemo.services.BookServiceImpl;
import com.example.springdemo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final AuthorServiceImpl authorService;
    private final BookServiceImpl bookService;
    private final CategoryService categoryService;
    private final BookRepository bookRepository;
    private AuthorRepository authorRepository;

    @Autowired
    public ConsoleRunner(AuthorServiceImpl authorService, BookServiceImpl bookService, CategoryService categoryService, BookRepository bookRepository, AuthorRepository authorRepository) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.categoryService = categoryService;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        this.categoryService.seedCategories();
        this.authorService.seedAuthors();

    }

    private void _01_booksAfter2000() {
        LocalDate year2000 = LocalDate.of(2000, 12, 31);

        List<Book> books = this.bookRepository.findByReleaseDateAfter(year2000);

        books.forEach(b -> System.out.println(b.getTitle()));

        int count = this.bookRepository.countByReleaseDateAfter(year2000);

        System.out.println("Total count: " + count);
    }

    private void _02_allAuthorsWithBookBefore1990() {
        LocalDate year1990 = LocalDate.of(1990, 1, 1);

        List<Author> authors = this.authorRepository.findDistinctByBooksReleaseDateBefore(year1990);

        authors.forEach(a -> System.out.println(a.getFirstName() + " " + a.getLastName()));
    }

    private void _03_allAuthorsOrderedByBookCount() {
        List<Author> authors = this.authorRepository.findAll();

        authors
                .stream()
                .sorted((l, r) -> r.getBooks().size() - l.getBooks().size())
                .forEach(author ->
                        System.out.printf("%s %s -> %d%n",
                                author.getFirstName(),
                                author.getLastName(),
                                author.getBooks().size()));
    }
}
