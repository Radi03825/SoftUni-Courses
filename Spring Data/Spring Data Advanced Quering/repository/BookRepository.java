package springintro.repository;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    @Query("SELECT b.title FROM Book b WHERE b.ageRestriction = :ageRestriction")
    List<String> findAllByAgeRestriction(@Param("ageRestriction") AgeRestriction ageRestriction);

    List<Book> findAllByCopiesIsLessThanAndEditionType(int copies, EditionType editionType);

    List<Book> findAllByPriceIsLessThanOrPriceGreaterThan(BigDecimal price, BigDecimal price2);

    List<Book> findAllByReleaseDateIsNot(LocalDate releaseDate);

    List<Book> findAllByTitleContaining(String string);

    List<Book> findAllByAuthorLastNameContaining(String string);

    @Query("SELECT count(b) FROM Book b WHERE length(b.title) > :count")
    int countAllByTitleIsGreaterThan(@Param("count") int count);

    @Query("SELECT b FROM Book b ORDER BY b.copies DESC")
    List<Book> findAllByCopiesOrderByCopiesDesc();
}
