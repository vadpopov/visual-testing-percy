package io.percy.examplepercyjavaselenium;

import config.DriverBase;
import io.percy.selenium.Percy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.util.Map;

public class CreatePageTest {
    private static WebDriver driver;
    private static Percy percy;

    @BeforeEach
    public void startAppAndOpenBrowser() throws IOException {
        driver = DriverBase.getDriver();
        percy = new Percy(driver);
    }

    @AfterEach
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void checkingCreatePage() {
        DriverBase.navigate("https://picsartstage2.com/create", Map.of("user_key", "7546288f-f401-4479-9a1f-40ee3bd78411", "language", "en"));
        DriverBase.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[title='User avatar']")));
        percy.snapshot("Create Page");
    }
}
