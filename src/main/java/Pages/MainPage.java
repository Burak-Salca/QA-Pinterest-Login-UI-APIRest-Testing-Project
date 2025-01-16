package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;

public class MainPage extends BaseTest {

    public String getAccountValue(){
        return driver.findElement(By.cssSelector("[class=\"sGz dyH iFc H2s\"]")).getText();
    }
}
