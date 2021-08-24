package io.percy.examplepercyjavaselenium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.HttpServer;

import config.DriverBase;
import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.percy.selenium.Percy;

/**
 * Unit test for example App.
 */
public class AuthorizationTest {
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
    public void checkingAuthorizationModal() {
        DriverBase.navigate("https://picsartstage2.com/create/video", Collections.singletonMap("language", "en"));
        percy.snapshot("Auth Window");

        driver.findElement(By.cssSelector("input[name='email']")).sendKeys(RandomString.make(10));
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(RandomString.make(10));
        percy.snapshot("Auth Window - filled");
    }
}
