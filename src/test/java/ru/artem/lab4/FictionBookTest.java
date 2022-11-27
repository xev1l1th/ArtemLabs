package ru.artem.lab4;

import org.junit.Assert;
import org.junit.Test;
import ru.artem.lab1.Author;
import ru.artem.lab1.Book;
import ru.artem.lab2.FictionBook;

public class FictionBookTest {

    @Test
    public void testGetDescriptionForFictionBook(){
        String bookName = "bookName";
        int releaseYear = 1234;
        String fighting = "fighting";
        Book book = new FictionBook(new Author("bibip", "bibip"), bookName, releaseYear, "123", null, fighting);
        Assert.assertEquals(book.getDescription(), bookName + " " + releaseYear + " " + fighting);
    }

}
