package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasketPage extends BasePage {
    public static void main(String[] args) {

    }

    public static void ClickAddToBasket() {
        if (!driver.getCurrentUrl().contains("p-")) {
            Assert.fail("You are not on product detail page");
            driver.close();
        } else {
            driver.findElement(By.xpath("//button[@id=\"addToCart\"]")).click();
        }
    }

    public static void ClickToGotoBasket() {
            driver.findElement(By.id("shoppingCart")).click();

            if (!driver.getCurrentUrl().contains("https://checkout.hepsiburada.com/sepetim") && driver.findElement(By.xpath("//h1[text()='Sepetim']")).isEnabled() == false) {
                Assert.fail("You are not on basket page");
                driver.close();
            } else {
                driver.findElement(By.xpath("//button[text()='Alışverişi tamamla']")).click();
                if (!driver.findElement(By.xpath("//h2[text()='Teslimat adresi']")).isDisplayed()) {
                    Assert.fail("You couldn't redirected to shipment page");
                    driver.close();
                } else {
                    driver.findElement(By.xpath("//button[text()=\"Devam et\"]")).click();
                    if (!driver.findElement(By.xpath("//h2[text()=\"Ödeme yöntemleri\"]")).isDisplayed()) {
                        Assert.fail("You couldn't click Devam et button");
                        driver.close();
                    }
                }
            }

    }
}
