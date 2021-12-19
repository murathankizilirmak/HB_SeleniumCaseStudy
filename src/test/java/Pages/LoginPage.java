package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {

    public static void main(String[] args) {

    }

    @Test
    public static void EnterYourCorrectInfo(String email, String password) {
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        try {
            WebDriverWait wait = new WebDriverWait(driver, 15);
            driver.findElement(By.xpath("//span[@title=\"Giriş Yap\"]")).click();
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("login"))));
            driver.findElement(By.id("login")).click();
            Thread.sleep(2500);
            if (driver.getCurrentUrl().contains("https://giris.hepsiburada.com/")) {
                driver.findElement(By.name("username")).sendKeys(email);
                driver.findElement(By.name("password")).sendKeys(password);
                driver.findElement(By.name("btnLogin")).click();
                Thread.sleep(4500);
                if(!driver.findElement(By.xpath("//div[text()=\"ARA\"]")).isDisplayed())
                {
                    BufferedImage capture = new Robot().createScreenCapture(screenRect);
                    ImageIO.write(capture, "jpg", new File(".\\src\\test\\java\\Screenshots\\Login.jpg"));
                    Assert.fail("You couldn't redirect to main page successfully");
                }
            }
        } catch (Exception ex) {

        }
    }
}
