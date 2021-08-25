package io.percy.examplepercyjavaselenium;

import config.DriverBase;
import io.percy.selenium.Percy;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Collections;

public class AuthorizationTest {
    private static WebDriver driver;
    private static Percy percy;

    @BeforeEach
    public void startAppAndOpenBrowser() {
        driver = DriverBase.getDriver();
        percy = new Percy(driver);
    }

    @AfterEach
    public void closeBrowser() {
        driver.close();
    }

    @Test
    public void checkingAuthorizationModal() {
        DriverBase.navigate("https://picsartstage2.com/create/video", Collections.singletonMap("language", "en"));
        percy.snapshot("Auth Window");

        driver.findElement(By.cssSelector("input[name='email']")).sendKeys(RandomString.make(10));
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(RandomString.make(10));
        percy.snapshot("Auth Window - filled");
    }
}
