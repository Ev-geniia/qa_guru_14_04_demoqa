package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsModal;
import com.demoqa.pages.components.StateCityComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {
    //Elements
    private CalendarComponent calendarComponent = new CalendarComponent();
    private StateCityComponent stateCityComponent = new StateCityComponent();
    private ResultsModal resultsModal = new ResultsModal();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            addressInput = $("#currentAddress");
    private final static String TITLE_TEXT = "Student Registration Form";
    //Actions
    public RegistrationFormPage openPage(){
        open("/automation-practice-form ");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }
    public RegistrationFormPage setFirstName(String value){
        firstNameInput.setValue(value);

        return this;
    }
    public RegistrationFormPage clearFirstName(){
        firstNameInput.clear();

        return this;
    }
    public RegistrationFormPage setLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }
    public RegistrationFormPage setEmail(String value){
        emailInput.setValue(value);

        return this;
    }
    public RegistrationFormPage setAddress(String value){
        addressInput.setValue(value);

        return this;
    }
    public RegistrationFormPage setGender(){
        $("#gender-radio-1").parent().click();

        return this;
    }
    public RegistrationFormPage setNumber(String value){
        $("#userNumber").setValue(value);

        return this;
    }
    public RegistrationFormPage setBirthDate(String day, String month, String year){
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }
    public RegistrationFormPage setSubjects(String value){
        $("#subjectsInput").setValue(value).pressEnter();

        return this;
    }
    public RegistrationFormPage setHobby(String value){
        $("#hobbiesWrapper").$(byText(value)).click();

        return this;
    }
    public RegistrationFormPage uploadPicture(String value){
        $("#uploadPicture").uploadFromClasspath(value);

        return this;
    }

    public RegistrationFormPage setStateCity(String state, String city){
        stateCityComponent.setStateCity(state, city);

        return this;
    }
    public RegistrationFormPage submit(){
        $("#submit").click();

        return this;
    }
    public RegistrationFormPage checkResultsTableVisible(){
        resultsModal.checkVisible();

        return this;
    }

    public RegistrationFormPage checkResult(String key, String value){
        resultsModal.checkResult(key, value);

        return this;
    }
}
