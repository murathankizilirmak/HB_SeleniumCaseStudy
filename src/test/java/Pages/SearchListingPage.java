package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SearchListingPage extends BasePage  {
    public static void ClickToProduct()
    {
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        if (driver.getCurrentUrl().contains("https://www.hepsiburada.com/ara?")) {
            driver.findElements(By.xpath("//h3[@class=\"product-title title\"]")).get(1).click();
            try {
                if(!driver.findElement(By.xpath("//button[@id=\"addToCart\"]")).isDisplayed())
                {
                    BufferedImage capture = new Robot().createScreenCapture(screenRect);
                    ImageIO.write(capture, "jpg", new File(".\\src\\test\\java\\Screenshots\\ClickToProductOnProductDetailPage.jpg"));
                    Assert.fail("Basket page not opened");
                }
            } catch (AWTException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
