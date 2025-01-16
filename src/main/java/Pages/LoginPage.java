package Pages;
import Base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends BaseTest {

    public LoginPage fillEmail(String email){
        driver.findElement(By.cssSelector("input#email")).sendKeys(email);
        return this;
    }

    public LoginPage fillPassword(String password){
        driver.findElement(By.cssSelector("input#password")).sendKeys(password);
        return this;
    }

    public LoginPage clickLogin(){
        driver.findElement(By.cssSelector("[class=\"RCK Hsu USg adn gn8 L4E kVc iyn S9z Vxj aZc pXK _co Il7 hNT BG7\"]")).click();
        return this;
    }

    public LoginPage emailErrorController(String errorMessage){
        String message = driver.findElement(By.cssSelector("#email-error > div > div > div:nth-child(2)")).getText();
        Assert.assertEquals(message.trim(),errorMessage.trim());
        return this;
    }

    public LoginPage passwordErrorController(String errorMessage){
        String message = driver.findElement(By.xpath("//*[@id=\"password-error\"]/div/div/div[2]/div/span[1]")).getText();
        Assert.assertEquals(message.trim(),errorMessage);
        return this;
    }
}
