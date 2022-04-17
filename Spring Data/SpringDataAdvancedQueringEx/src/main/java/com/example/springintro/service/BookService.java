package com.example.springintro.service;

import com.example.springintro.model.entity.AgeRestriction;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<String> findAllTitlesOfBooksByGiVenAgeRes(AgeRestriction ageRestriction);

    List<String> findAllTitlesOfTheGoldenBooks();

    List<String> findBooksByPriceNotBetween();

    List<String> findAllTitleOfBooksNotReleasedInYear(int year);

    List<String> findAllBooksReleasedBeforeDate(LocalDate date);

    List<String> findAllTitlesContaining(String check);

    List<String> findAllByAuthor_LastNameStartsWith(String str);

    Integer countBooks(int number);

    int increaseBookCopies(LocalDate localDate, int numberToIncrease);

    String reducedBookInfo(String title);

    int deleteBooksLowerThanGivenNumberOfCopies(int number);

    int getTotalAmountOfBooksByGivenAuthor(String firstName, String lastName);
}
