package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import javax.print.DocFlavor;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class MainPage extends BasePage {

    public static void main(String[] args) {

    }

    @Test
    public static void Search() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@class='desktopOldAutosuggestTheme-input']"))));
        if (driver.getCurrentUrl().contains("https://www.hepsiburada.com/")) {
            driver.findElement(By.xpath("//input[@class='desktopOldAutosuggestTheme-input']")).sendKeys("kitaplık");
            driver.findElement(By.xpath("//div[text()=\"ARA\"]")).click();
            try {
                if (driver.findElements(By.xpath("//h3[@class='product-title title']")).size() == 0) {
                    BufferedImage capture = new Robot().createScreenCapture(screenRect);
                    ImageIO.write(capture, "jpg", new File(".\\src\\test\\java\\Screenshots\\Login.jpg"));
                    Assert.fail("Search listing page not opened properly");
                    driver.close();
                }
           } catch (  AWTException | IOException e) {
               e.printStackTrace();
           }

        }
    }
}