package com.demoqa;
import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class StudentFormTest {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillStudentForm() {
        open("/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue("Anna");
        $("#lastName").setValue("Peters");
        $("#userEmail").setValue("anna.peters@yahoo.com");
        $("[for=gender-radio-2]").click();
        $("#userNumber").setValue("7049432621");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1998");
        $(".react-datepicker__day--026").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("[for=hobbies-checkbox-3").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/photo.jpeg"));
        $("#currentAddress").setValue("910 Cameron village drive");
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Panipat").pressEnter();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-dark").shouldHave(text("Anna Peters"));
        $(".table-dark").shouldHave(text("anna.peters@yahoo.com"));
        $(".table-dark").shouldHave(text("Female"));
        $(".table-dark").shouldHave(text("7049432621"));
        $(".table-dark").shouldHave(text("26 November,1998"));
        $(".table-dark").shouldHave(text("910 Cameron village drive"));
        $(".table-dark").shouldHave(text("Math"));
    }
}














