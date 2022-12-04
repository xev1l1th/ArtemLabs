package ru.artem.lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.ToString;
import ru.artem.StringUtils;
import ru.artem.lab1.exceptions.BookNameException;
import ru.artem.lab1.exceptions.CirculationException;
import ru.artem.lab1.exceptions.CoAuthorAlreadyPresentException;
import ru.artem.lab1.exceptions.NoPresentAuthorException;
import ru.artem.lab1.exceptions.ReleaseYearException;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Book {

    protected Author author;
    protected String bookName;
    protected Integer releaseYear;
    //тираж
    protected String circulation;
    protected List<Author> coauthors;

    public Book(Author author, String bookName, Integer releaseYear, String circulation, List<Author> coauthors){
        if(StringUtils.isEmpty(bookName)){
            throw new BookNameException();
        }
        if(StringUtils.isEmpty(circulation)){
            throw new CirculationException();
        }
        if(releaseYear == null){
            throw new ReleaseYearException();
        }
        if(author == null){
            throw new NoPresentAuthorException();
        }
        this.author = author;
        this.bookName = bookName;
        this.releaseYear = releaseYear;
        this.circulation = circulation;
        this.coauthors = coauthors;
    }

    public void addCoAuthor(Author author){
        if(coauthors == null){
            this.coauthors = new ArrayList<>();
        }
        if(coauthors.contains(author)){
            throw new CoAuthorAlreadyPresentException();
        }
        coauthors.add(author);
    }

    public String getDescription(){
        return bookName + " " + releaseYear;
    }
}
