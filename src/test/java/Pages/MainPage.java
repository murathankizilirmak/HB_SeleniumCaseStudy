package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class MainPage extends  BasePage {

    public static void main(String[] args) {

    }

    @Test
    public static void ClickRandomElement()
    {
        driver.findElement(By.xpath("/html/body/main/div/div[1]/div[1]/div[1]/a/span")).click();
        int countelementsizewithinmainpage = driver.findElements(By.className("products__item-inner")).size();
        Random rnd = new Random();
        int generatenumber= rnd.nextInt(countelementsizewithinmainpage);
        List<WebElement> SelectOneOfElement= driver.findElements(By.className("products__item-inner"));
        SelectOneOfElement.get(generatenumber).click();
    }

}