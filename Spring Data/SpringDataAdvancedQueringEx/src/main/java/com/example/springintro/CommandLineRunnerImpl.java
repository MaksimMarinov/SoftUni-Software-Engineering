package com.example.springintro;

import com.example.springintro.model.entity.AgeRestriction;

import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Locale;


@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final BufferedReader bufferedReader;
    private String decision;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService, BufferedReader bufferedReader) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.bufferedReader = bufferedReader;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("If you didn't seed the data please enter seed. If you already did that just press any key");
        this.decision = bufferedReader.readLine();
        if (decision.equals("seed")) {
            seedData();
        }
        while (!decision.equals("end")){

            System.out.println("Please enter the number of exercise you want to check:");
            System.out.println("If you already done with checking enter end in the console");

            this.decision = bufferedReader.readLine();
            switch (decision) {
                case "1" -> booksTitlesByAgeRestriction();
                case "2" -> goldenBooks();
                case "3" -> booksByPrice();
                case "4" -> notReleasedBook();
                case "5" -> booksReleasedBeforeDate();
                case "6" -> authorSearch();
                case "7" -> bookSearch();
                case "8" -> bookTitleSearch();
                case "9" -> countBooks();
                case "10" -> totalBookCopies();
                case "11" -> reducedBook();
                case "12" -> increaseBookCopies();
                case "13" -> removeBooks();
                case "14" -> storedProcedure();
                case "end" -> escape();
                default -> System.out.println("This is not valid task number");
            }

        }


    }

    private void escape() {
        System.out.println("Please give me 10");
        System.out.println("Bye");
    }

    private void storedProcedure() throws IOException {

        System.out.println("I couldn't solve this task! So, if you want to see what exception " +
                "was thrown press y" +
                " else just press any key and you will back. Just to remind you this is not obligatory task");
        this.decision=bufferedReader.readLine();
        if (!decision.equals("y")){
            return;
        }
        System.out.println("Create procedure as mine from src/main/resources/files/procedure.txt");
        System.out.println("if you solve this task give the code please and now enjoy the exception");
        System.out.println("Please enter full_name with space");
        String[] tokens = bufferedReader.readLine().trim().split("\\s+");
        String firstName = tokens[0];
        String lastName = tokens[1];
        bookService.getTotalAmountOfBooksByGivenAuthor(firstName, lastName);

    }

    private void removeBooks() throws IOException {
        System.out.println("Please enter minimum number of copies:");
        int number = Integer.parseInt(bufferedReader.readLine().trim());
        System.out.println("this is the number of affected rows but you can check in database");
        System.out.println(this.bookService.deleteBooksLowerThanGivenNumberOfCopies(number));
    }


    private void increaseBookCopies() throws IOException {
        System.out.println("Please enter date in format dd MMM yyyy: ");
        LocalDate localDate = LocalDate.parse(bufferedReader.readLine(),
                DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH));
        System.out.println("Please enter number to update: ");
        int number = Integer.parseInt(bufferedReader.readLine().trim());
        System.out.println(bookService.increaseBookCopies(localDate, number));

    }

    private void reducedBook() throws IOException {
        System.out.println("Please enter the title:");
        String title = bufferedReader.readLine().trim();
        System.out.println(this.bookService.reducedBookInfo(title));
    }

    private void totalBookCopies() {
        authorService.getAllAuthorsAngTheirCountOfCopies()
                .forEach(System.out::println);
    }

    private void countBooks() throws IOException {
        System.out.println("Please enter number:");
        int number = Integer.parseInt(bufferedReader.readLine());
        System.out.println(this.bookService.countBooks(number));

    }

    private void bookTitleSearch() throws IOException {
        System.out.println("Please enter the string: ");
        String startStr = bufferedReader.readLine();
        this.bookService.findAllByAuthor_LastNameStartsWith(startStr)
                .forEach(System.out::println);
    }

    private void bookSearch() throws IOException {
        System.out.println("please enter the string: ");
        String check = bufferedReader.readLine().trim();
        bookService.findAllTitlesContaining(check)
                .forEach(System.out::println);

    }

    private void authorSearch() throws IOException {
        System.out.println("please enter the string for checking:");
        String end = bufferedReader.readLine().trim();
        this.authorService.getAllAuthorWhichFirstNameEndsWith(end)
                .forEach(System.out::println);

    }

    private void booksReleasedBeforeDate() throws IOException {
        System.out.println("please enter the date in format dd-MM-yyyy: ");
        LocalDate dateToCheck = LocalDate.parse(bufferedReader.readLine(),
                DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.bookService.findAllBooksReleasedBeforeDate(dateToCheck)
                .forEach(System.out::println);
    }

    private void notReleasedBook() throws IOException {
        System.out.println("Please enter year:");
        int year = Integer.parseInt(bufferedReader.readLine());

        bookService.findAllTitleOfBooksNotReleasedInYear(year)
                .forEach(System.out::println);

    }

    private void booksByPrice() {
        bookService.findBooksByPriceNotBetween()
                .forEach(System.out::println);
    }

    private void goldenBooks() {

        this.bookService.findAllTitlesOfTheGoldenBooks()
                .forEach(System.out::println);
    }

    private void booksTitlesByAgeRestriction() throws IOException {
        System.out.println("please enter the age restriction");
        AgeRestriction ageRestriction = AgeRestriction.valueOf(bufferedReader.readLine().toUpperCase());
        this.bookService.findAllTitlesOfBooksByGiVenAgeRes(ageRestriction)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
