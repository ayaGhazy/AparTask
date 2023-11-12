package actions;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class AssertActions extends KeywordActionsGet {
WebDriver driver;
    public AssertActions(WebDriver driver) {
        super( driver);
        this.driver=driver;
    }

    Assertion assertion(boolean flag) {
        if (flag)
            return new Assertion();
        else return new SoftAssert();
    }

    public void assertTextVariable(WebElement element, String expected, boolean flag) {
        // flag =0 means hard assert , flag =1 means soft assert
        // expected variable should be located at variables.xslx sheet
        // actual will be located at class KeywordActionsGet
        String actual = getText(element);
        assertion(flag).assertEquals(actual, expected, "Expected text:" + expected + " is not equal actual:" + actual);
        System.out.println("Expected text:" + expected + " is  equal actual:" + actual);
    }
    public void assertTextRejex(String actual, String expected, boolean flag) {
        // flag =0 means hard assert , flag =1 means soft assert
        assertion(flag).assertTrue(actual.matches( expected), "Expected text:" + expected + " is not equal actual:" + actual);
        System.out.println("Expected text matches actual:" + actual);
    }

    public void assertAttribute(String element, String attribute, String expected, boolean flag) {
        String actual = getAttribute(element, attribute);
        assertion(flag).assertEquals(actual, getVariable(expected), "This attribute " + attribute + " is not found");
    }




}

