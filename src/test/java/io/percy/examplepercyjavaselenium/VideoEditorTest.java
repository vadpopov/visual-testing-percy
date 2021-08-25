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

public class VideoEditorTest {
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
    public void checkingCreatePage() throws InterruptedException {
        DriverBase.navigate("https://picsartstage2.com/create/video", Map.of("user_key","7546288f-f401-4479-9a1f-40ee3bd78411", "language", "en"));
        DriverBase.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='upload']")));

        driver.findElement(By.cssSelector("[data-test='sidebar_fit']")).click();
        DriverBase.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='tool-panel_fit']")));
        driver.findElement(By.cssSelector("[data-test='ratio-format_select-instagramSquare']")).click();
        driver.findElement(By.cssSelector("[data-test='sidebar_templates']")).click();

        //eyes.check(Target.region(By.cssSelector("[data-test='artBoard']")).exact().withName("Canvas ratio check"));
        //eyes.check(Target.region(By.cssSelector("[data-test='sidebar']")).strict().withName("Tools sidebar check"));

        percy.snapshot("Vide Editor with fit tool opened");
    }
}
