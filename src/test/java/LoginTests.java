import Base.BaseTest;
import Pages.LoginPage;
import Pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class LoginTests extends BaseTest {

    LoginPage loginpage = new LoginPage();
    MainPage mainPage = new MainPage();

    @Test(description = "Başarılı giriş kontrolü")
    public void TC01() throws InterruptedException{
        loginpage.fillEmail(email)
                .fillPassword(password)
                .clickLogin();
        sleep(5000);
        Assert.assertEquals(mainPage.getAccountValue(),"S");
    }

    @Test(description = "Yanlış email formatında griş kontrolü")
    public void TC02() throws InterruptedException{
        loginpage.fillEmail("siyah.0699qhotmail.com")
                .fillPassword(password)
                .clickLogin();
        sleep(5000);
        boolean isEmailValid = Pattern.matches(emailRegex, "siyah.0699qhotmail.com");
        if (!isEmailValid) {
            loginpage.emailErrorController("Bu bir e-posta adresine benzemiyor.");
        }
    }

    @Test(description = "Yanlış email ile giriş kontrolü")
    public void TC03() throws InterruptedException{
        loginpage.fillEmail("siyah.9999@hotmail.com")
                .fillPassword(password)
                .clickLogin();
        sleep(5000);
       loginpage.emailErrorController("Girdiğiniz e-posta hiçbir hesaba ait değil.");
    }

    @Test(description = "Yanlış password ile giriş kontrolü")
    public void TC04() throws InterruptedException{
        loginpage.fillEmail(email)
                .fillPassword("0000000000000000000000000000000000000000000000")
                .clickLogin();
        sleep(5000);
        loginpage.passwordErrorController("Girdiğiniz parola yanlış. Tekrar deneyin veya");
    }
}
