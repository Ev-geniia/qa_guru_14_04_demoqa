package com.demoqa;

import org.junit.jupiter.api.*;

import java.lang.module.Configuration;

public class ExampleJUnit5Test {

    @BeforeAll
    static void configure() {
        System.out.println("this is the beforeall");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("this is the afterall");
    }

    @BeforeEach
    void beforeTest() {
        System.out.println("        this is beforeach");
    }

    @Test
    void firstTest(){
        System.out.println("    this is the first test");
    }

    @Test
    void secondTest(){
        System.out.println("    this is the second test");
    }
}
