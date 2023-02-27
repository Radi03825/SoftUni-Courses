package springintro.service;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import org.springframework.data.jpa.repository.Query;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findAllBooksWithAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByCopiesIsLessThanAndEditionType(int copies, EditionType editionType);

    List<Book> findAllByPriceIsLessThanOrPriceGreaterThan(BigDecimal price, BigDecimal price2);

    List<Book> findAllByReleaseDateIsNot(LocalDate releaseDate);

    List<Book> findAllByTitleContaining(String string);

    List<Book> findAllByAuthorLastNameContaining(String string);

    int countAllByTitleIsGreaterThan(int count);

    List<Book> findAllByCopiesOrderByCopiesDesc();

}
