package Pages;
import Base.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends BaseTest {

    @Step("Email alanı dolduruldu")
    public LoginPage fillEmail(String email){
        driver.findElement(By.cssSelector("input#email")).sendKeys(email);
        return this;
    }

    @Step("Password alanı dolduruldu")
    public LoginPage fillPassword(String password){
        driver.findElement(By.cssSelector("input#password")).sendKeys(password);
        return this;
    }

    @Step("Login butonuna tıklandı")
    public LoginPage clickLogin(){
        driver.findElement(By.cssSelector("[class=\"RCK Hsu USg adn gn8 L4E kVc iyn S9z Vxj aZc pXK _co Il7 hNT BG7\"]")).click();
        return this;
    }

    @Step("Email için hata mesajı alındı")
    public LoginPage emailErrorController(String errorMessage){
        String message = driver.findElement(By.cssSelector("#email-error > div > div > div:nth-child(2)")).getText();
        Allure.addAttachment(message,"");
        screenshot();
        Assert.assertEquals(message.trim(),errorMessage.trim());
        return this;
    }

    @Step("Password için hata mesajı alındı")
    public LoginPage passwordErrorController(String errorMessage){
        String message = driver.findElement(By.xpath("//*[@id=\"password-error\"]/div/div/div[2]/div/span[1]")).getText();
        Allure.addAttachment(message,"");
        screenshot();
        Assert.assertEquals(message.trim(),errorMessage);
        return this;
    }
}
