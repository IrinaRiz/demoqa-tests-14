package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {

    @BeforeAll
    static void configure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        String remote = System.getProperty("selenide_remote");
        if (remote != null && !remote.equals("")) {
            Configuration.remote = remote;
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
        }

        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserPosition = "0x0";

        Configuration.browserSize = System.getProperty("browser_name", "chrome");
        Configuration.browserVersion = System.getProperty("browser_version", "100.0");
        Configuration.browserSize = System.getProperty("browser_size", "1920x1080");
    }

//        DesiredCapabilities capabilities = new DesiredCapabilities();
////        capabilities.setCapability("browserName", "chrome");
////        capabilities.setCapability("browserVersion", "100.0");
//        capabilities.setCapability("enableVNC", true);
//        capabilities.setCapability("enableVideo", true);
//
//        Configuration.browserCapabilities = capabilities;
//        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.browserSize = "1920x1080";
//        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";


    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
