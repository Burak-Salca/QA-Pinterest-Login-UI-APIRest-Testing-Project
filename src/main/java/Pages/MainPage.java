package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;

public class MainPage extends BaseTest {

    @Step("Kullanıcı bilgisi alındı")
    public String getAccountValue() throws InterruptedException {
        sleep(1000);
        screenshot();
        return driver.findElement(By.cssSelector("[class=\"sGz dyH iFc H2s\"]")).getText();
    }
}
