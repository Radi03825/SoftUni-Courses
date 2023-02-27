package main.java.com.example.springdemo.services;

import com.example.springdemo.models.*;
import main.java.com.example.springdemo.repositories.AuthorRepository;
import main.java.com.example.springdemo.repositories.BookRepository;
import main.java.com.example.springdemo.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService{
    
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private CategoryRepository categoryRepository;
    private AuthorService authorService;
    private CategoryService categoryService;
    
    @Override
    public void seedBooks() throws IOException {
        Files.readAllLines(Path.of("Spring Data/Exam/src/main/resources/files/books.txt"))
                .stream()
                .filter(s -> !s.isBlank())
                .map(this::getBookObject)
                .forEach(bookRepository::save);
    }

    private Book getBookObject(String line) {
        String[] bookParts = line.split(" ");

        int editionTypeIndex = Integer.parseInt(bookParts[0]);
        EditionType editionType = EditionType.values()[editionTypeIndex];

        LocalDate publishDate =
                LocalDate.parse(bookParts[1], DateTimeFormatter.ofPattern("d/M/yyyy"));

        int copies = Integer.parseInt(bookParts[2]);
        Double price = Double.parseDouble(bookParts[3]);

        int ageRestrictionIndex = Integer.parseInt(bookParts[4]);
        AgeRestriction ageRestriction = AgeRestriction.values()[ageRestrictionIndex];

        String title = Arrays.stream(bookParts)
                .skip(5)
                .collect(Collectors.joining(" "));


        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService.getRandomCategories();

        return new Book(title, editionType, price, copies, publishDate,
                ageRestriction, author, categories);
    }

}
