package ru.artem.lab1;

import java.util.Objects;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.ToString;
import ru.artem.StringUtils;
import ru.artem.lab1.exceptions.AuthorCreationException;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Author {

    private String firstName;
    private String secondName;

    public Author(String firstName, String secondName) {
        if(StringUtils.isEmpty(firstName) || StringUtils.isEmpty(secondName)){
            throw new AuthorCreationException();
        }
        this.firstName = firstName;
        this.secondName = secondName;
    }
}
