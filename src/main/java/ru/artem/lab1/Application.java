package ru.artem.lab1;

import java.util.Scanner;
import ru.artem.lab1.exceptions.Lab1Exception;

public class Application {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Throwable {


        System.out.println("Enter Book");
        System.out.println("Book name: ");
        String bookName = scanner.next();
        System.out.println("authorsName name: ");
        String authorName = scanner.next();
        System.out.println("authorsFamilyName name: ");
        String authorsFamilyName = scanner.next();
        System.out.println("circulation: ");
        String circulation = scanner.next();
        System.out.println("year: ");
        int year = scanner.nextInt();

        /*
        Book book = Book.builder()
            .author(author)
            .bookName(bookName)
            .releaseYear(year)
            .circulation(circulation)
            .build();


         */
    }

}
