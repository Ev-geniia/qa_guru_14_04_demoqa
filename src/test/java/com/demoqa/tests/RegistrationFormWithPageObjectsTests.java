package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RegistrationFormWithPageObjectsTests {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        //Steps
        registrationFormPage.openPage()
                .setFirstName("Egor")
                .setLastName("Egorov")
                .setEmail("Egor@Egorov.com")
                .setGender()
                .setNumber("71234567890")
                .setBirthDate("13", "July", "1989")
                .setSubjects("Arts")
                .setHobby("Music")
                .uploadPicture("img/1.png")
                .setAddress("Some address 1")
                .setStateCity("NCR", "Delhi")
                .submit();

        //Checks
        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", "Egor Egorov")
                .checkResult("Student Email", "Egor@Egorov.com")
                .checkResult("Date of Birth", "13 July,1989");


    } @Test
    void fillFormWithMinimumDataTest() {
        //Steps
        registrationFormPage.openPage()
                .setFirstName("Egor")
                .setLastName("Egorov")
                .setEmail("Egor@Egorov.com")
                .setGender()
                .setNumber("71234567890")
                .submit();
        //Checks
        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", "Egor Egorov")
                .checkResult("Student Email", "Egor@Egorov.com");

    }

}