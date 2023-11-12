package actions;

import org.openqa.selenium.WebDriver;

public class KeyWordsActionManager  {
    WebDriver driver;
   public KeywordActionsElement keywordActionsElement;
    public KeywordActionsWait keywordActionsWait;
    public AssertActions assertActions;
    public KeywordActionsGet keywordActionsGet;

    public KeyWordsActionManager(WebDriver driver ) {
        this.driver=driver;
        keywordActionsElement =new KeywordActionsElement(driver);
        keywordActionsWait =new KeywordActionsWait(driver);
        assertActions =new AssertActions(driver);
        keywordActionsGet =new KeywordActionsGet(driver);
    }


}
