package Pages;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class LoginPage extends  BasePage {

    public static void main(String[] args) {

    }
    @Test
    public static void EnterYourCorrectInfo(String email,String password) {
        try {
            driver.findElement(By.id("EmailLogin")).sendKeys(email);
            driver.findElement(By.id("Password")).sendKeys(password);
            driver.findElement(By.xpath("//*[@id=\"userLogin\"]/div[6]/button")).click();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            driver.findElement(By.xpath("/html/body/main/div/div[1]/div[1]/div[1]/a/span"));
        } catch (Exception ex) {
            System.out.println("Doğru kullanıcı adı ve şifre ile login olunamadı.");
        }
    }
    @Test
    public static  void EnterYourWrongCredentials(String email,String password)
    {
            driver.findElement(By.id("EmailLogin")).sendKeys(email);
            driver.findElement(By.id("Password")).sendKeys(password);
            driver.findElement(By.xpath("//*[@id=\"userLogin\"]/div[6]/button")).click();
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            driver.findElement(By.xpath("//*[@id=\"modalBox\"]/div/div"));

    }
}
