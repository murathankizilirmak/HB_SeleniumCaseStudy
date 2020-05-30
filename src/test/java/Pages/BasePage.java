package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BasePage {
    public static WebDriver driver;

    public static void main(String[] args) {
    }
    @Test
    public static void OpenPortal(String BrowserType) {
        switch (BrowserType) {
            case "Firefox":
                if (BrowserType.equals("Firefox")) {
                    System.setProperty("webdriver.gecko.driver", "C:\\Users\\mkizilirmak\\IdeaProjects\\CicekSepetiSelenium\\Browserdrivers\\geckodriver.exe");
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.get("https://www.lolaflora.com/login");
                }
                break;
            case "Chrome":
                if (BrowserType.equals("Chrome")) {
                    System.setProperty("webdriver.chrome.driver", "C:\\Users\\mkizilirmak\\IdeaProjects\\CicekSepetiSelenium\\Browserdrivers\\chromedriver.exe");
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.get("https://www.lolaflora.com/login");
                }
        }
    }
}

