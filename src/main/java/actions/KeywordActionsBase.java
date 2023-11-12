package actions;

import csv.CSVReaderManager;
import objectRepository.ObjectElement;
import objectRepository.ObjectGenerator;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import testData.TestDataGenerator;
import utilites.EnumClass;
import utilites.Global;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class KeywordActionsBase   {

    ObjectGenerator objectGenerator;
   public WebDriver driver;
    TestDataGenerator testDataGenerator;
    protected KeywordActionsBase(WebDriver driver ) {

        this.driver = driver;
        objectGenerator = new ObjectGenerator();
        testDataGenerator=new TestDataGenerator();
    }
    public String getVariable(String variableName)
    {
      return   testDataGenerator.getVariableValue(variableName);
    }
    public List<String> getVariables(String variableName)
    {
        return   testDataGenerator.getVariableValues(variableName);
    }
    protected WebElement  findElement(String element)
    {
        ObjectElement objectElements = objectGenerator.generateObject(element);
        EnumClass.FindBy findByValue= objectElements.getFindBy();
        String valueValue=objectElements.getValue();
        return   driver.findElement(findBy(findByValue,valueValue));
    }

    public List<WebElement> findElements(String element)
    {
        ObjectElement objectElements = objectGenerator.generateObject(element);
        EnumClass.FindBy findByValue= objectElements.getFindBy();
        String valueValue=objectElements.getValue();
        return   driver.findElements(findBy(findByValue,valueValue));
    }
    protected By findBy(String element)
    {
        // get platform = android
        ObjectElement objectElements = objectGenerator.generateObject(element);
        EnumClass.FindBy findByValue= objectElements.getFindBy();
        String valueValue=objectElements.getValue();
        return   (findBy(findByValue,valueValue));
    }

    private By findBy(EnumClass.FindBy findByValue, String valueValue)
    {
        switch (findByValue)
        {
            case id:
                return  By.id(valueValue);
            case name:
                return By.name(valueValue);
            case xpath:
                return By.xpath(valueValue);
            case css:
                return By.cssSelector(valueValue);
            case className:
                return By.className(valueValue);
            case partialLinkText:
                return By.partialLinkText(valueValue);

            default: return  By.id(valueValue);
        }
    }

      public void takeSnapShot(String imgName)
      {
          TakesScreenshot scrShot =((TakesScreenshot)driver);

          //Call getScreenshotAs method to create image file
         try {
             File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

             //Move image file to new destination

             File DestFile = new File(Global.getProperty("ScreenShotPath")+"/"+imgName);

             //Copy file at destination

             FileUtils.copyFile(SrcFile, DestFile);
         } catch (IOException e) {
             e.printStackTrace();
         }

      }
  Map<String,Object> fromStringToMap(String text)
  {
      HashMap<String, Object> mapObject = new HashMap();
      if (!(StringUtils.isEmpty(text) || text.equals(""))) {
          String[] textArray = text.split("~~");
          // split text to map
          for (String var : textArray) {
              String[] key = var.split(":");
              mapObject.put(key[0].trim(), key[1].trim());
          }
      }
      return mapObject;
  }


}
