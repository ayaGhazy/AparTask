package driverManagement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeDriverManager extends WebDriverManagerBase {


    @Override
    public WebDriver getDriver()  {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");

        driver=new ChromeDriver(options);
        return driver;
    }
    @Override
    public void setupDriver()
    {
        WebDriverManager.chromedriver().setup();
    }


}
