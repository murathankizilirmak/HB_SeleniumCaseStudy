package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BasePage {
    public static WebDriver driver;

    public static void main(String[] args) {
    }
    @Test
    public static void OpenPortal(String BrowserType) {
        switch (BrowserType) {
            case "Firefox":
                if (BrowserType.equals("Firefox")) {
                    System.setProperty("webdriver.gecko.driver", ".\\Browserdrivers\\geckodriver.exe");
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.get("https://www.hepsiburada.com");
                    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                }
                break;
            case "Chrome":
                if (BrowserType.equals("Chrome")) {
                    System.setProperty("webdriver.chrome.driver", ".\\Browserdrivers\\chromedriver.exe");
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.get("https://www.hepsiburada.com");
                    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                }
        }
    }
    @AfterTest
    public void close()
    {
        driver.quit();
    }
}

