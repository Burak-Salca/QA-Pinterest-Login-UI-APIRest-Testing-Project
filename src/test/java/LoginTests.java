import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class LoginTests {

    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){

        driver = new ChromeDriver();
        driver.get("https://tr.pinterest.com/login/");

    }

    @Test
    public void TC01() throws InterruptedException{

        driver.findElement(By.cssSelector("input#email")).sendKeys("siyah.0699@hotmail.com");
        driver.findElement(By.cssSelector("input#password")).sendKeys("Siyah.0699");
        driver.findElement(By.cssSelector("[class=\"RCK Hsu USg adn gn8 L4E kVc iyn S9z Vxj aZc pXK _co Il7 hNT BG7\"]")).click();
        Thread.sleep(5000);
        System.out.println(driver.findElement(By.cssSelector("[class=\"sGz dyH iFc H2s\"]")).getText());
        Assert.assertEquals(driver.findElement(By.cssSelector("[class=\"sGz dyH iFc H2s\"]")).getText(),"S");

    }

    @Test
    public void TC02() throws InterruptedException{

        driver.findElement(By.cssSelector("input#email")).sendKeys("siyah.0699qhotmail.com");
        driver.findElement(By.cssSelector("input#password")).sendKeys("Siyah.0699");
        driver.findElement(By.cssSelector("[class=\"RCK Hsu USg adn gn8 L4E kVc iyn S9z Vxj aZc pXK _co Il7 hNT BG7\"]")).click();
        Thread.sleep(5000);
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        boolean isEmailValid = Pattern.matches(emailRegex, "siyah.0699qhotmail.com");
        if (!isEmailValid) {
            System.out.println(driver.findElement(By.cssSelector("#email-error > div > div > div:nth-child(2)")).getText());
            Assert.assertEquals(driver.findElement(By.cssSelector("#email-error > div > div > div:nth-child(2)")).getText().trim(), "Bu bir e-posta adresine benzemiyor.".trim());
        }
    }

    @Test
    public void TC03() throws InterruptedException{

        driver.findElement(By.cssSelector("input#email")).sendKeys("siyah.9999@hotmail.com");
        driver.findElement(By.cssSelector("input#password")).sendKeys("Siyah.0699");
        driver.findElement(By.cssSelector("[class=\"RCK Hsu USg adn gn8 L4E kVc iyn S9z Vxj aZc pXK _co Il7 hNT BG7\"]")).click();
        Thread.sleep(5000);
        System.out.println(driver.findElement(By.xpath("//*[@id=\"email-error\"]/div/div/div[2]")).getText());
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"email-error\"]/div/div/div[2]")).getText().trim(),"Girdiğiniz e-posta hiçbir hesaba ait değil.".trim());

    }

    @Test
    public void TC04() throws InterruptedException{

        driver.findElement(By.cssSelector("input#email")).sendKeys("siyah.0699@hotmail.com");
        driver.findElement(By.cssSelector("input#password")).sendKeys("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
        driver.findElement(By.cssSelector("[class=\"RCK Hsu USg adn gn8 L4E kVc iyn S9z Vxj aZc pXK _co Il7 hNT BG7\"]")).click();
        Thread.sleep(5000);
        System.out.println(driver.findElement(By.xpath("//*[@id=\"password-error\"]/div/div/div[2]/div/span[1]")).getText());
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"password-error\"]/div/div/div[2]/div/span[1]")).getText().trim(),"Girdiğiniz parola yanlış. Tekrar deneyin veya ".trim());

    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
