package pages;

import actions.KeyWordsActionManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Home extends Utilities {

    @Step("Switch to English")

    public  void switchToEnglish()
    {
        // validate if language is eng
       if(! actions.keywordActionsGet.getText("languageBtn").trim().equals("العربية"))
           actions.keywordActionsElement.click("languageBtn");

    }

    // Validate price
     public void validateSubscription( String currency) {
         List<WebElement> elements= actions.keywordActionsElement.findElements("type");
         for (int i=0;i< elements.size();i++) {
            String typeText=actions.keywordActionsElement.getVariables("type").get(i);
             System.out.println("Validate type= "+typeText);
             actions.assertActions.assertTextVariable(elements.get(i), typeText, true);
             List<WebElement> elementsPrice= actions.keywordActionsElement.findElements("price");

             String actualText = actions.keywordActionsGet.getText(elementsPrice.get(i));
             System.out.println("validate Subscription "+actualText+" for type= "+typeText);
             String expected = "(\\d*\\.?\\d*) " + currency + "\\/month";
             actions.assertActions.assertTextRejex(actualText, expected, true);
         }
     }
}
