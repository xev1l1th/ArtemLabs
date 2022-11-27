package ru.artem;

import java.util.Collections;
import lombok.experimental.UtilityClass;
import ru.artem.lab2.FictionBook;
import ru.artem.lab2.Reader;
import ru.artem.lab2.ScienceBook;

@UtilityClass
public class SimpleFactory {

    public Reader createIvanTheReader(){
        Reader reader = new Reader("ivan", "ivan");
        reader.setPreferences(Collections.singletonList(FictionBook.class));
        return reader;
    }

    public Reader createArtemTheReader(){
        Reader reader = new Reader("artem", "artem");
        reader.setPreferences(Collections.singletonList(ScienceBook.class));
        return reader;
    }

}
