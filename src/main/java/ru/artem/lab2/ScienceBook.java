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
public class ScienceBook extends Book {

    @Setter
    @Getter
    protected String theme;

    public ScienceBook(Author author, String bookName, Integer releaseYear, String circulation, List<Author> coauthors, String theme) {
        super(author, bookName, releaseYear, circulation, coauthors);
        this.theme = theme;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " " + theme;
    }
}
