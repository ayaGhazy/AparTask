package actions;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class KeywordActionsGet extends KeywordActionsBase {
    // variableActions should be defined   @BeforeSuite

    public KeywordActionsGet(WebDriver driver) {
        super( driver);

    }

    public String getText(String element) { // return text
        return findElement(element).getText();
    }
    public String getText(WebElement element) { // return text
        return element.getText();
    }
    public String getUrl() { // return text
        return driver.getCurrentUrl();
    }
    public String getSelectedOption(String element) { // return text
        return findElement(element).getText();
    }




        public String getAttribute (String element, String att)
        { // return text
            return findElement(element).getAttribute(att);
        }
    public String getAttribute (WebElement element, String att)
    { // return text
        return element.getAttribute(att);
    }
        public String getHeight (String element){
            float elementSizeY = findElement(element).getSize().height;
            String elementHeight = String.valueOf(elementSizeY);
            return elementHeight;

        }

        public String getWidth (String element){
            float elementSizeX = findElement(element).getSize().width;
            String elementWidth = String.valueOf(elementSizeX);
            return elementWidth;
        }


    public boolean isDisplayed(String element){
        return findElement(element).isDisplayed();}

        public String getOTP (String element){ // return OTP
            return findElement(element).getText();
        }


    public Boolean getExist(String element)
    { // return text
        try {
            findElement(element);
            return true;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }


            public boolean isEnabled (String element){
                return findElement(element).isEnabled();
            }

            public String getLocation (String element){
                int leftX = findElement(element).getLocation().getX();
                int rightX = leftX + findElement(element).getSize().getWidth();
                int middleX = (rightX + leftX) / 2;
                String middleXstring = String.valueOf(middleX);

                float upperY = findElement(element).getLocation().getY();
                float lowerY = upperY + findElement(element).getSize().getHeight();
                float middleY = (upperY + lowerY) / 2;
                String middleYstring = String.valueOf(middleY);

                String location = middleXstring + middleYstring;
                return location;
            }

     public int[] getLocationArray(String element){
        int leftX = findElement(element).getLocation().getX();
        int rightX = leftX + findElement(element).getSize().getWidth();
        int middleX = (rightX + leftX) / 2;
        String middleXstring = String.valueOf(middleX);
        int upperY = findElement(element).getLocation().getY();
        int lowerY = upperY + findElement(element).getSize().getHeight();
        int middleY = (upperY + lowerY) / 2;
        String middleYstring = String.valueOf(middleY);
        int[] coordinates = {middleX,middleY};
        return coordinates;
    }

    }
