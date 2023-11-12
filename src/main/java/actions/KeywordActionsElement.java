package actions;

import csv.CSVReaderManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import utilites.Global;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class KeywordActionsElement extends KeywordActionsWait {
    Actions actions;
//set variable sheet csv

    KeywordActionsElement(WebDriver driver) {

        super(driver);
        actions = new Actions(driver);
        //
    }
    public void quit()
    {
        driver.quit();
    }


    public void close()
    {
        driver.close();
    }
    public void navigate(String url) {
        driver.navigate().to(url);
    }


    public void click(String element) {
        WebElement webElement =findElement(element);
       
        webElement.click();
    }

}