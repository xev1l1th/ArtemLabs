package ru.artem.services;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.artem.SimpleFactory;
import ru.artem.lab1.exceptions.Lab1Exception;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class InMemoryReaderImplTest {

    @Autowired
    private ReaderServiceImpl service;

    @Test
    public void testGetAllReadersExpectZeroContent(){
        Assertions.assertEquals(service.getAllReaders().size(),  0);
    }

    @Test
    public void testAddNewReader(){
        service.addReader(SimpleFactory.createArtemTheReader());
        Assertions.assertEquals(service.getAllReaders().size(), 1);
        //now we have to remove cos we use singleton reader service while testing
        service.delete(SimpleFactory.createArtemTheReader());
        //we can use cos we defined equals and hashcode
        Assertions.assertEquals(service.getAllReaders().size(), 0);
    }

    @Test
    public void testGetAlReadersExpectZeroContent(){
        Assertions.assertEquals(service.getAllReaders().size(),  0);
    }

    @Test(expected = Lab1Exception.class)
    public void updateReaderShouldThrowExceptionCosNoSuchReaderPresent(){
        service.update(SimpleFactory.createArtemTheReader());
    }


}
