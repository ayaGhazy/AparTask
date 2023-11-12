package actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilites.EnumClass;
import utilites.Global;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class KeywordActionsWait extends KeywordActionsBase {


    WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds( Long.parseLong(Global.getProperty("defaultWaitTime"))));

    public KeywordActionsWait(WebDriver driver) {
        super( driver);
    }

    public void waitElementToClickable(String element) {
        webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(findElement(element))));

    }
    public void waitElementToClickable(WebElement element) {
        webDriverWait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));

    }
    public void waitPageToLoad()
    {
        webDriverWait.until(webDriver -> "complete".equals(((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState")));
    }

    public void waitElementToDisplay(String element, int timeSecond) {

        webDriverWait.until(ExpectedConditions.visibilityOf(findElement(element)));

    }


    public void waitElementNotExistence(String element) {
        webDriverWait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(findBy(element))));
    }


    public void waitElementToDisplay(String element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(findElement(element)));

    }
    public void waitElementnotSlated(String element) {
        webDriverWait.ignoring(StaleElementReferenceException.class)
                .until((WebDriver d) -> {
                    findElement(element).click();
                    return true;
                });

    }
    public void waitElementToDisappear(String element) {
        webDriverWait.until(ExpectedConditions.invisibilityOf(findElement(element)));

    }


    public void waitElementExistence(String element) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(findBy(element)));
    }

    public void sleep(EnumClass.sleepMode type, int time)  {
     try {
         if (type.equals(EnumClass.sleepMode.HOURS)) {
             TimeUnit.HOURS.sleep(time);
         } else if (type.equals(EnumClass.sleepMode.Min)) {
             TimeUnit.MINUTES.sleep(time);
         } else if (type.equals(EnumClass.sleepMode.Mill)) {
             TimeUnit.MILLISECONDS.sleep(time);
         } else {
             TimeUnit.SECONDS.sleep(time);
         }
     }
     catch (InterruptedException e)
     {
         e.printStackTrace();
     }
    }


}


