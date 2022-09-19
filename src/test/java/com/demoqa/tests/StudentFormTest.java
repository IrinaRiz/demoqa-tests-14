package com.demoqa.tests;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class  StudentFormTest extends TestBase {
    RegistrationFormPage registrationFormPage= new RegistrationFormPage();

    @Test
    @Tag("properties")
    void fillStudentForm() {
        registrationFormPage.openPage()
                .setFirstName("Anna")
                .setLastName("Peters")
                .setEmail("anna.peters@yahoo.com")
                .setGender("Female")
                .setPhoneNumber("7049432621")
                .setBirthDay("30","July","1998")
                .setSubject("Math")
                .selectHobby()
                .uploadPicture()
                .setAddress("910 Cameron village drive")
                .setState("Haryana")
                .setCity("Karnal")
                .clickSubmitButton();

        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", "Anna Peters")
                .checkResult("Student Email", "anna.peters@yahoo.com")
                .checkResult("Date of Birth", "30 July,1998")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "7049432621")
                .checkResult("Subjects", "Math")
                .checkResult("Hobbies","Music")
                .checkResult("Address","910 Cameron village drive")
                .checkResult("State and City","Haryana Karnal");
    }
}
