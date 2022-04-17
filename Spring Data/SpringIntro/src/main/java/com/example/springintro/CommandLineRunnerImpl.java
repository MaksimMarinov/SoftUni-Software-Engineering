package com.example.springintro;

import com.example.springintro.Entity.Book;
import com.example.springintro.Service.AuthorService;
import com.example.springintro.Service.BookService;
import com.example.springintro.Service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private  BufferedReader bf;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {

        String decision="";
        bf = new BufferedReader(new InputStreamReader(System.in));
        while (!decision.equals("n")){
            System.out.println("If you one to check one of the queries please enter number one to four as it is in the word file or");
            System.out.println("if you want to check how is data seed please press five and don't forget to clear your base:");
            decision  = bf.readLine();
            switch (decision){
                case "1" -> printAllBooksAfter2000();
                case "2"-> printAllAuthorsNamesBefore1990(1990);
                case "3" -> printAllAuthorsAndNumberOfTheirBooks();
                case "4" -> printAllBookByAuthorNameOrderByReleaseDate("George", "Powell");
                case"5"-> seedData();
                default -> System.out.println("Wrong task number! Please enter single number from 1 to 5");

            }
            System.out.println("if you want to check another task please enter please press any key else enter single n");
            decision = bf.readLine();

        }
        System.out.println("Please give me 10 :)");
        System.out.println("Bye!");


    }

    private void printAllBookByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService.findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
        .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService.
                getAllAuthorsOrderByCountOfTheirBooks().forEach(System.out::println);
    }

    private void printAllAuthorsNamesBefore1990(int year) {
        bookService.findAllAuthorsWithBooksWithReleaseDataBeforeYear(year)
        .forEach(System.out::println);
    }

    private void printAllBooksAfter2000() {
        bookService.findAllBooksAfterYear(2000)
                .stream().map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
