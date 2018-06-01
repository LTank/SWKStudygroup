package com.example.xpdayone.businesslogic;

import com.example.xpdayone.model.Database;
import com.example.xpdayone.model.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class StatsCalculatorTest {

    StatsCalculator statsCalculator; // code to test

    @Mock
    Database database;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this); // Spring
        statsCalculator = new StatsCalculator(database);
    }

    @Test
    public void getAverageAmount() {
        // Lav test fixture:
        List<User> users = new ArrayList<>();
        users.add(new User(1,"", 123));
        users.add(new User(1,"", 124));
        users.add(new User(1,"", 125));
        when(database.getAllUsers()).thenReturn(users);
        assertEquals(124, statsCalculator.getAverageAmount(), 0.0);


    }
}