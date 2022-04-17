package com.example.springintro.impl;

import com.example.springintro.Entity.*;
import com.example.springintro.Service.AuthorService;
import com.example.springintro.Service.BookService;
import com.example.springintro.Service.CategoryService;
import com.example.springintro.repository.BookRepository;
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

@Service
public class BookServiceImpl implements BookService {
    private static final String BOOKS_PATH = "src/main/resources/books.txt";
    private final BookRepository bookRepository;
    private final CategoryService categoryService;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, CategoryService categoryService, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.categoryService = categoryService;
        this.authorService = authorService;
    }


    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }
        Files.readAllLines(Path.of(BOOKS_PATH))
                .forEach(row -> {
                    String[] bookInfo = row.split("\\s+");
                    Book book = createBookFromInfo(bookInfo);
                    bookRepository.save(book);
                });
    }

    @Override
    public List<Book> findAllBooksAfterYear(int year) {

        return bookRepository.findAllByReleaseDateAfter(LocalDate.of(year, 12, 31));
    }

    @Override
    public List<String> findAllAuthorsWithBooksWithReleaseDataBeforeYear(int year) {
       return bookRepository.findAllByReleaseDateBefore(LocalDate.of(year, 1,1))
                .stream().map(book -> String.format("%s %s", book.getAuthor().getFirstName(), book.getAuthor()
                .getLastName())).distinct().collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName) {

        return  bookRepository.findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(firstName, lastName)
                .stream().map(book -> String.format("%s %s %d", book.getTitle(), book.getReleaseDate(), book.getCopies()))
                .collect(Collectors.toList());
    }


    private Book createBookFromInfo(String[] bookInfo) {
        EditionType editionType = EditionType.values()[Integer.parseInt(bookInfo[0])];
        LocalDate releaseDate = LocalDate.parse(bookInfo[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        int copies = Integer.parseInt(bookInfo[2]);
        BigDecimal price = new BigDecimal(bookInfo[3]);
        AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(bookInfo[4])];

        String title = Arrays.stream(bookInfo).skip(5)
                .collect(Collectors.joining(" "));
        Set<Category> categories = categoryService.getRandomCategories();
        Author author = authorService.getRandomAuthor();


        return new Book(title, editionType, releaseDate, price, copies,  ageRestriction, author, categories);
    }
}
