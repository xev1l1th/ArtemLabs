package ru.artem.lab4;

import static org.mockito.Mockito.mock;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;
import ru.artem.SimpleFactory;
import ru.artem.lab1.Book;
import ru.artem.lab1.exceptions.Lab1Exception;
import ru.artem.lab2.FictionBook;
import ru.artem.lab2.Reader;
import ru.artem.lab2.ScienceBook;

public class ReaderTest {


    @Test(expected = Lab1Exception.class)
    public void testReaderDontLikeThisBookException() {
        Book book = mock(FictionBook.class);
        Reader readerWhoLikesOnlyScienceBook = SimpleFactory.createArtemTheReader();
        readerWhoLikesOnlyScienceBook.startReadBook(book);
    }

    @Test(expected = Lab1Exception.class)
    public void testReaderDontLikeScienceBookException() {
        Book book = mock(ScienceBook.class);
        Reader reader = SimpleFactory.createIvanTheReader();
        reader.startReadBook(book);
    }

    @Test
    public void testSetPreferencesForReader() {
        Book book = mock(FictionBook.class);
        Reader reader = SimpleFactory.createArtemTheReader();
        reader.setPreferences(Arrays.asList(ScienceBook.class, FictionBook.class));
        reader.startReadBook(book);
        Assert.assertEquals(reader.getBooksHeReading().size(),1);
    }

    @Test
    public void testStartAndCompleteReadBook(){
        Book book = mock(ScienceBook.class);
        Reader reader = SimpleFactory.createArtemTheReader();
        reader.startReadBook(book);
        Assert.assertEquals(1, reader.getBooksHeReading().size());
        reader.stopReadBook(book);
        Assert.assertEquals(0, reader.getBooksHeReading().size());
    }

}
