package driverManagement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxDriverManager extends WebDriverManagerBase {


    @Override
    public WebDriver getDriver()  {
            driver=new FirefoxDriver();
        return driver;
    }
    @Override
    public void setupDriver()
    {
        WebDriverManager.firefoxdriver().setup();
    }

}
