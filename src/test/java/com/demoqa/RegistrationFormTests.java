package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.timeout = 10000; // 10 seconds
//        Configuration.browser = "opera";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form ");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        //$("[class=practice-form-wrapper]").shouldHave(text("Student Registration Form"));
        //. for class, # for id

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue("Egor");
        $("#lastName").setValue("Egorov");
        $("#userEmail").setValue("Egor@Egorov.com");
        $("#gender-radio-1").parent().click();
        $("#userNumber").setValue("71234567890");
        $("#dateOfBirthInput").click();

        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1989");
        $(".react-datepicker__day--013:not(.react-datepicker__day--outside-month)").click();

        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");

        $("#currentAddress").setValue("Some address 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();


        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").shouldHave(text("Egor"));
        $(".table-responsive").$(byText("Date of Birth"))
                .parent().shouldHave(text("13 July,1989"));

    }

}