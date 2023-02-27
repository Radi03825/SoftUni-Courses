package springintro.service.impl;

import com.example.springintro.model.entity.*;
import springintro.repository.BookRepository;
import springintro.service.AuthorService;
import springintro.service.BookService;
import springintro.service.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.springintro.model.entity.EditionType.GOLD;

@Service
public class BookServiceImpl implements BookService {

    private static final String BOOKS_FILE_PATH = "Spring Data/Exam/src/main/resources/files/books.txt";

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }

        Files
                .readAllLines(Path.of(BOOKS_FILE_PATH))
                .forEach(row -> {
                    String[] bookInfo = row.split("\\s+");

                    Book book = createBookFromInfo(bookInfo);

                    bookRepository.save(book);
                });
    }

    @Override
    public List<Book> findAllBooksAfterYear(int year) {
        return bookRepository
                .findAllByReleaseDateAfter(LocalDate.of(year, 12, 31));
    }

    @Override
    public List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year) {
        return bookRepository
                .findAllByReleaseDateBefore(LocalDate.of(year, 1, 1))
                .stream()
                .map(book -> String.format("%s %s", book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName) {
       return bookRepository
                .findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(firstName, lastName)
                .stream()
                .map(book -> String.format("%s %s %d",
                        book.getTitle(),
                        book.getReleaseDate(),
                        book.getCopies()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksWithAgeRestriction(AgeRestriction ageRestriction) {
        return bookRepository.findAllByAgeRestriction(ageRestriction).stream()
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findAllByCopiesIsLessThanAndEditionType(int copies, EditionType editionType) {
        return bookRepository.findAllByCopiesIsLessThanAndEditionType(copies, editionType);
    }

    @Override
    public List<Book> findAllByPriceIsLessThanOrPriceGreaterThan(BigDecimal price, BigDecimal price2) {
        return bookRepository.findAllByPriceIsLessThanOrPriceGreaterThan(price, price2);
    }

    @Override
    public List<Book> findAllByReleaseDateIsNot(LocalDate releaseDate) {
        return bookRepository.findAllByReleaseDateIsNot(releaseDate);
    }

    @Override
    public List<Book> findAllByTitleContaining(String string) {
        return bookRepository.findAllByTitleContaining(string.toLowerCase());
    }

    @Override
    public List<Book> findAllByAuthorLastNameContaining(String string) {
        return bookRepository.findAllByAuthorLastNameContaining(string.toLowerCase());
    }

    @Override
    public int countAllByTitleIsGreaterThan(int count) {
        return bookRepository.countAllByTitleIsGreaterThan(count);
    }

    @Override
    public List<Book> findAllByCopiesOrderByCopiesDesc() {
        return bookRepository.findAllByCopiesOrderByCopiesDesc();
    }

    private Book createBookFromInfo(String[] bookInfo) {
        EditionType editionType = EditionType.values()[Integer.parseInt(bookInfo[0])];
        LocalDate releaseDate = LocalDate
                .parse(bookInfo[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        Integer copies = Integer.parseInt(bookInfo[2]);
        BigDecimal price = new BigDecimal(bookInfo[3]);
        AgeRestriction ageRestriction = AgeRestriction
                .values()[Integer.parseInt(bookInfo[4])];
        String title = Arrays.stream(bookInfo)
                .skip(5)
                .collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService
                .getRandomCategories();

        return new Book(editionType, releaseDate, copies, price, ageRestriction, title, author, categories);

    }
}
