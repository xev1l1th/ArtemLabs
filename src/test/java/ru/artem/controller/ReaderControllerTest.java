package ru.artem.controller;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.artem.lab2.Reader;
import ru.artem.services.ReaderService;

@WebMvcTest(value = ReaderController.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ReaderControllerTest {

    private static final ObjectMapper MAPPER = new ObjectMapper()
        .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .registerModule(new JavaTimeModule());

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReaderService readerServivce;

    @MockBean
    private UserDetailsService userDetailsService;

    @Test
    public void testGetRequest() throws Exception {
        when(readerServivce.getAllReaders()).thenReturn(new ArrayList<>());

        mockMvc.perform(get("/readers")
            .with(user("user")))
            .andExpect(status().isOk());
    }

    @Test
    public void testUnauthorizedRequest() throws Exception{
        when(readerServivce.getAllReaders()).thenReturn(new ArrayList<>());

        mockMvc.perform(get("/readers")
            .with(httpBasic("123", "123")))
            .andExpect(status().isUnauthorized());
    }

    @Test
    public void testRoleAdmonAuthenticationShouldDeny() throws Exception{
        when(readerServivce.getAllReaders()).thenReturn(new ArrayList<>());

        mockMvc.perform(post("/readers")
            .contentType(MediaType.APPLICATION_JSON)
            .content(asJsonString(new Reader("Artem", "Andreev")))
            .with(user("123").password("pass").roles("USER").authorities(()->"USER")))
            .andExpect(status().is(403));
    }

    private static String asJsonString(final Object obj) {
        try {
            return MAPPER.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
