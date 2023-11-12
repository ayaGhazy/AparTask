package driverManagement;


import utilites.EnumClass;

public class WebDriverFactory {
    public WebDriverManagerBase getWebDriver(EnumClass.webBrowser platform)
    {
        if (platform.equals(EnumClass.webBrowser.ff))
        {
            return new FireFoxDriverManager();
        }
        else if (platform.equals(EnumClass.webBrowser.ch))
        {
            return new ChromeDriverManager();
        }

        else return new WebDriverManagerBase();
    }

}
