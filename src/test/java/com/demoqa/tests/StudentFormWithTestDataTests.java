package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.Test;

import static com.demoqa.tests.TestData.*;
import static java.lang.String.format;

public class StudentFormWithTestDataTests extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

//        String firstname;
//        String lastName;
//        String expectedFullName;
//        String email;
//        String gender;
//        String phoneNumber;
//        String day;
//        String month;
//        String year;
//        String comma;
//        String expectedBirthDay;
//        String subject;
//        String hobby;
//        String address;
//        String state;
//        String city;
//        String expectedStateAndCity;
//
//    @BeforeEach
//    void prepareTestData() {
//         firstname = "Anna";
//         lastName = "Peters";
//         expectedFullName = format("%s %s", firstname, lastName);
//         email = "anna.peters@yahoo.com";
//         gender = "Female";
//         phoneNumber = "7049432621";
//         day = "30";
//         month = "July";
//         year = "1998";
//         comma = ",";
//         expectedBirthDay = format("%s %s%s%s", day, month, comma, year);
//         subject = "Math";
//         hobby = "Music";
//         address = "910 Cameron village drive";
//         state = "Haryana";
//         city = "Karnal";
//         expectedStateAndCity = format("%s %s", state, city);
//    }

    @Test
    void fillStudentForm() {
        String expectedFullName = format("%s %s", firstname, lastName);
        String comma = ",";
        String expectedBirthDay = format("%s %s%s%s", day, month, comma, year);
        String expectedStateAndCity = format("%s %s", state, city);
        registrationFormPage.openPage()
                .setFirstName(firstname)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .setBirthDay(day, month, year)
                .setSubject(subject)
                .selectHobby()
                .uploadPicture()
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmitButton();

        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", expectedFullName)
                .checkResult("Student Email", email)
                .checkResult("Date of Birth", expectedBirthDay)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Address", address)
                .checkResult("State and City", expectedStateAndCity);
    }
}
