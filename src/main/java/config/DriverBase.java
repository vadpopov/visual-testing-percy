package config;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class DriverBase {
    private static ChromeDriver driver;
    private static WebDriverWait wait;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static WebDriverWait getWait() {
        if (wait == null) {
            wait = new WebDriverWait(driver, 30);
        }
        return wait;
    }


    public static void navigate(String url) {
        driver.get(url);
        driver.manage().addCookie(new Cookie("OptanonAlertBoxClosed", "2021-08-16T18:50:14.006Z"));
        driver.manage().addCookie(new Cookie("language", "ru"));
        driver.navigate().refresh();
    }

    public static void navigate(String url, Map<String, String> cookies) {
        driver.get(url);
        driver.manage().addCookie(new Cookie("OptanonAlertBoxClosed", "2021-08-16T18:50:14.006Z"));
        for (Map.Entry<String, String> stringStringEntry : cookies.entrySet()) {
            Map.Entry pair = (Map.Entry) stringStringEntry;
            driver.manage().addCookie(new Cookie(pair.getKey().toString(), pair.getValue().toString()));
        }
        LocalStorage local = ((WebStorage) driver).getLocalStorage();

        local.setItem("isFirstVisit", "1");
        driver.navigate().refresh();
    }
}
