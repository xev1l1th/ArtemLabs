package ru.artem.lab2;

import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.artem.lab1.Author;
import ru.artem.lab1.Book;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FictionBook extends Book {

    @Getter
    @Setter
    //жанр
    protected String genre;

    public FictionBook(Author author, String bookName, Integer releaseYear, String circulation, List<Author> coauthors, String genre) {
        super(author, bookName, releaseYear, circulation, coauthors);
        this.genre = genre;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " " + genre;
    }
}
