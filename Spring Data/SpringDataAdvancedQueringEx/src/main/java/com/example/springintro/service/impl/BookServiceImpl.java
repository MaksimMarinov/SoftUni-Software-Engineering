package com.example.springintro.service.impl;

import com.example.springintro.model.entity.*;
import com.example.springintro.repository.BookRepository;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

@Service
public class BookServiceImpl implements BookService {

    private static final String BOOKS_FILE_PATH = "src/main/resources/files/books.txt";

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
    public List<String> findAllTitlesOfBooksByGiVenAgeRes(AgeRestriction ageRestriction) {
        return bookRepository.findBooksByAgeRestrictionEquals(ageRestriction)
                .stream().map(Book::getTitle).collect(Collectors.toList());
    }

    @Override
    public List<String> findAllTitlesOfTheGoldenBooks() {
        return this.bookRepository.findBooksByEditionTypeEqualsAndCopiesIsLessThan(EditionType.GOLD, 5000)
                .stream().map(Book::getTitle).collect(Collectors.toList());

    }

    @Override
    public List<String> findBooksByPriceNotBetween() {
        return bookRepository.findBooksByPriceIsLessThanOrPriceIsGreaterThan(BigDecimal.valueOf(5), BigDecimal.valueOf(40))
                .stream().map(book -> String.format("%s - $%.2f", book.getTitle(), book.getPrice())).collect(Collectors.toList());
    }

    @Override
    public List<String> findAllTitleOfBooksNotReleasedInYear(int year) {
        LocalDate lower = LocalDate.of(year, 1, 12);
        LocalDate upper = LocalDate.of(year, 12, 31);
        return bookRepository.findBooksByReleaseDateBeforeOrReleaseDateAfter(lower, upper)
                .stream().map(Book::getTitle).collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksReleasedBeforeDate(LocalDate date) {
        return this.bookRepository.findBooksByReleaseDateBefore(date)
                .stream().map(book -> String.format("%s %s %.2f", book.getTitle(), book.getEditionType().name(), book.getPrice()))
                .collect(Collectors.toList());

    }

    @Override
    public List<String> findAllTitlesContaining(String check) {
        return this.bookRepository.findBooksByTitleContaining(check)
                .stream().map(Book::getTitle).collect(Collectors.toList());
    }

    @Override
    public List<String> findAllByAuthor_LastNameStartsWith(String str) {
        return this.bookRepository.findAllByAuthor_LastNameStartsWith(str)
                .stream().map(book -> String.format("%s (%s %s)", book.getTitle(), book.getAuthor().getFirstName(), book.getAuthor().getLastName())
                ).collect(Collectors.toList());

    }

    @Override
    public Integer countBooks(int number) {
        return this.bookRepository.countBookByTitleLengthGreaterThan(number);
    }

    @Override
    @Transactional
    public int increaseBookCopies(LocalDate localDate, int numberToIncrease) {
        int affectedRows = this.bookRepository.updateCopiesByReleaseDate(numberToIncrease, localDate);
        return affectedRows * numberToIncrease;
    }

    @Override
    public String reducedBookInfo(String title) {

        return this.bookRepository.findTitleCategoriesAgeRestrictionPrice(title)
                .stream().map(book -> String.format("%s %s %s %.2f", book.getTitle(), book.getEditionType().name(), book.getAgeRestriction().name(), book.getPrice()))
                .findFirst().orElse("Book with that title is not exist!");

    }

    @Override
    @Transactional
    public int deleteBooksLowerThanGivenNumberOfCopies(int number) {
        return this.bookRepository.deleteAllByCopiesIsLessThan(number);
    }

    @Override
    public int getTotalAmountOfBooksByGivenAuthor(String firstName, String lastName) {
        return this.bookRepository.totalAmountOfBooksByAuthor(firstName, lastName);
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
