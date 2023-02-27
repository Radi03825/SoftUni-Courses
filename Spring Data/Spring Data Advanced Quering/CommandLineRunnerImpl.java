package springintro;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        //printAllBooksAfterYear(2000);
//        printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
     //   printAllAuthorsAndNumberOfTheirBooks();
      //  pritnALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");

        Scanner scanner = new Scanner(System.in);

        /*(1) String type = scanner.nextLine().toUpperCase();

        bookService.findAllBooksWithAgeRestriction(AgeRestriction.valueOf(type))
                .forEach(b -> System.out.println(b));

         */

        // (2) bookService.findAllByCopiesIsLessThanAndEditionType(5000, EditionType.GOLD).forEach(b -> System.out.println(b.getTitle()));

        // (3) bookService.findAllByPriceIsLessThanOrPriceGreaterThan(BigDecimal.valueOf(5), BigDecimal.valueOf(40)).forEach(b -> System.out.println(b.getTitle() + " - $" + b.getPrice()));

        // (4) bookService.findAllByReleaseDateIsNot(LocalDate.ofEpochDay(2005)).forEach(b -> System.out.println(b.getTitle()));

        // (7) bookService.findAllByTitleContaining("sK").forEach(b -> System.out.println(b.getTitle()));

        // (8) bookService.findAllByAuthorLastNameContaining("Ric").forEach(b -> System.out.println(b.getTitle() + " " + b.getAuthor().getLastName()));

        // (9) System.out.println(bookService.countAllByTitleIsGreaterThan(12));

        // (10) bookService.findAllByCopiesOrderByCopiesDesc().forEach(b -> System.out.println(b.getTitle() + " " + b.getCopies()));


    }

    private void printALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
