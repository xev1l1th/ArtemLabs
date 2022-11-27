package ru.artem.lab1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import ru.artem.lab1.exceptions.Lab1Exception;

public class AuthorTest {

    @Test(expected = Lab1Exception.class)
    public void authorCreationTestShouldThrowExceptionIfHisNameIsInvalid(){
        new Author(null, null);
    }

    @Test
    public void authorCreationSuccessfulTest(){
        new Author("Alexander", "Kolotushkin");
    }

    @Test
    public void equalsAndHashCokeTestShouldFailCosJonHasNeverBeenABastard(){
        Author steve = new Author("Ned's", "Bastard");
        Author jon = new Author("Jon", "Snow");
        assertFalse(steve.equals(jon));
        assertFalse(steve.hashCode() == jon.hashCode());
    }

    @Test
    public void equalsAndHashCokeTestShouldPass(){
        Author jon = new Author("Jon", "Snow");
        Author aegonTargaryen = new Author("Jon", "Snow");
        assertEquals(jon, aegonTargaryen);
        assertEquals(jon.hashCode(), aegonTargaryen.hashCode());
    }

}
