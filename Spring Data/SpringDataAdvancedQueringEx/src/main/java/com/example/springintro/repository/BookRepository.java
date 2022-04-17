package com.example.springintro.repository;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    //List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    //List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    //List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);
    List<Book> findBooksByAgeRestrictionEquals(AgeRestriction ageRestriction);

    List<Book> findBooksByEditionTypeEqualsAndCopiesIsLessThan(EditionType editionType, int numberOfCopies);

    List<Book> findBooksByPriceIsLessThanOrPriceIsGreaterThan(BigDecimal low, BigDecimal high);

    List<Book> findBooksByReleaseDateBeforeOrReleaseDateAfter(LocalDate lower, LocalDate upper);

    List<Book> findBooksByReleaseDateBefore(LocalDate before);

    List<Book> findBooksByTitleContaining(String check);

    List<Book> findAllByAuthor_LastNameStartsWith(String startStr);

    //мисля че работи и без @param
    @Query("SELECT COUNT(b) FROM Book b WHERE LENGTH(b.title) > :number")
    Integer countBookByTitleLengthGreaterThan(@Param(value = "number") int number);

    @Modifying
    @Query("UPDATE Book b SET b.copies = b.copies + :numberToIncrease WHERE b.releaseDate > :date")
    int updateCopiesByReleaseDate(@Param(value = "numberToIncrease") int numberToIncrease,
                                  @Param(value = "date") LocalDate date);

    @Modifying
    @Query("SELECT b FROM Book b WHERE b.title = :title")
    List<Book> findTitleCategoriesAgeRestrictionPrice(String title);

    int deleteAllByCopiesIsLessThan(int numberOfCopies);

    @Procedure("MyProcedure")
    Integer totalAmountOfBooksByAuthor(@Param(value = "first_name") String firstName,
                                       @Param(value = "last_name") String lastName);
}
