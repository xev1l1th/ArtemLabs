package ru.artem.lab2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import ru.artem.lab1.Author;
import ru.artem.lab1.Book;
import ru.artem.lab1.exceptions.Lab1Exception;
import ru.artem.lab2.exceptions.BookReadAlreadyPresentException;
import ru.artem.lab2.exceptions.FavouriteAuthorAlreadyPresentException;
import ru.artem.lab2.exceptions.ReaderAlreadyReadThisBookException;
import ru.artem.lab2.exceptions.ReaderHaveNotReadThisBookException;

@Data
@EqualsAndHashCode
@ToString
public class Reader {

    private String firstName;
    private String secondName;
    private List<Book> booksRead;
    private List<Book> booksHeReading;
    private List<Author> favouriteAuthors;
    private List<Class<? extends Book>> preferences;

    public Reader(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.booksHeReading = new ArrayList<>();
        this.booksRead = new ArrayList<>();
        this.favouriteAuthors = new ArrayList<>();
        //prefer all (default)
        this.preferences = new ArrayList<>(
            Arrays.asList(ScienceBook.class, FictionBook.class, Book.class));
    }

    public void startReadBook(Book book) {
        if (this.booksHeReading.contains(book)) {
            throw new ReaderAlreadyReadThisBookException();
        }

        for (Class<?> classz : preferences) {
            if (classz.isInstance(book)){
                this.booksHeReading.add(book);
                return;
            }
        }
        throw new Lab1Exception("user dont like this book");
    }

    public void completeReadBook(Book book) {
        if (!this.booksHeReading.contains(book)) {
            throw new ReaderHaveNotReadThisBookException();
        }
        this.booksRead.add(book);
    }

    public void stopReadBook(Book book) {
        if (!this.booksHeReading.contains(book)) {
            throw new ReaderHaveNotReadThisBookException();
        }
        this.booksHeReading.remove(book);
    }

    public void addFavouriteAuthor(Author author) {
        if (this.favouriteAuthors.contains(author)) {
            throw new FavouriteAuthorAlreadyPresentException();
        }
        this.favouriteAuthors.add(author);
    }

    public void addBooksRead(Book book) {
        if (this.booksRead.contains(book)) {
            throw new BookReadAlreadyPresentException();
        }
        this.booksRead.add(book);
    }

}
