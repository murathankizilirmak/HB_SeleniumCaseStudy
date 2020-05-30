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
    @Test
    public static void ClickDateFromList() {

        driver.findElement(By.className("js-html-tag-replace")).sendKeys("01001");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> aaa = driver.findElements(By.className("product-location__results-item"));
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        aaa.get(1).click();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        List<WebElement> finddateelement = driver.findElements(By.className("product__dates-col"));
        WebElement hiddendates = driver.findElement(By.className("js-hidden-date-input"));

        if (finddateelement.size() != 0 && finddateelement.get(1).isDisplayed()) {

            finddateelement.get(1).click();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            Select drpDate = new Select(driver.findElement(By.name("AddToCartModel.DeliveryHour")));

            if (drpDate.getOptions().size() > 1) {
                drpDate.selectByIndex(0);
                driver.findElement(By.className("product__action-col")).click();
            } else {
                driver.findElement(By.className("product__action-col")).click();
            }

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            driver.findElement(By.className("product__action-col")).click();
            Assert.fail("Ürün sepete atılamadı");
        }

    }

    @Test
    public  static  void CheckStarsPopupVisible()
    {
 try{
     driver.findElement(By.xpath("//*[@id=\"productDetailSend\"]/div/div/div/div[2]/div[1]/div/div[2]/div[4]/div")).click();
     WebElement aa= driver.findElement(By.xpath("//*[@id=\"productDetailSend\"]/div/div/div/div[2]/div[1]/div/div[2]/div[4]/div/div"));
 }
 catch (Exception e) {
     e.printStackTrace();
 }



    }

}
