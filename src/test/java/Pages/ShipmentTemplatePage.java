package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ShipmentTemplatePage extends BasePage {

    public static void ClickToContinueButtonOnShipmentPage() {
        if (!driver.getCurrentUrl().contains("https://checkout.hepsiburada.com/odeme")) {
            Assert.fail("You couldn't open payment page");
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage capture = null;
            try {
                capture = new Robot().createScreenCapture(screenRect);
                ImageIO.write(capture, "jpg", new File(".\\src\\test\\java\\Screenshots\\ClickToContinueButtonOnShipmentPage.jpg"));
            } catch (AWTException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
