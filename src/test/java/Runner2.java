import io.qameta.allure.Description;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.Home;
import pages.Utilities;

public class Runner2 {
    Utilities utilities;
    Home homePage;

    public Runner2() {
         utilities = new Utilities();
         homePage= new Home();
    }

    @BeforeTest
    public void setup(ITestContext context)
    {

        utilities.initialize();

    }
//    @BeforeMethod
//   // public void refresh()
//    {
//        utilities.openUrl();
//    }

    @Test (priority = 0,dataProvider = "url-data-provider", description="Test Case 1",retryAnalyzer = RetryAnalyzer.class)
    @Description("Test Description: Validate the Subscription Packages")
    public void TestCase1(String url,String currency)
    {
        System.out.println("validate Country with url="+url);
        // open url for selected country
        utilities.openUrl(url);
        // validate to open  in english
       homePage.switchToEnglish();
       // validate Subscription
        homePage.validateSubscription(currency);
    }

    @DataProvider (name = "url-data-provider")
    public Object[][] urlMethod(){
        return new Object[][] {
                {"https://subscribe.stctv.com/sa-ar","SAR"},
                {"https://subscribe.stctv.com/bh-ar","BHD"},
                {"https://subscribe.stctv.com/kw-ar","KWD"}
        };
    }
    @AfterMethod
    public void report()
    {
        utilities.report();
    }
    @AfterTest
    public void close()
    {
        utilities.quit();
    }
}
