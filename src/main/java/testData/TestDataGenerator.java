package testData;

import csv.CSVReaderManager;
import csv.IReader;
import utilites.EnumClass;
import utilites.Global;

import java.util.List;
import java.util.Random;

public class TestDataGenerator {
        final IReader variableSheet;
    public TestDataGenerator(String filePath, String fileName) {
        variableSheet= CSVReaderManager.getInstance(filePath, fileName);
    }

    public TestDataGenerator() {


        variableSheet= CSVReaderManager.getInstance(Global.getProperty("ObjectRepositoryFilePath"), Global.getProperty("TestDataSheetName"));

    }
    // load all rows

    //colname based on ios wala android
    public  String getVariableValue(String variableName)
    {
        if (variableName.equalsIgnoreCase("$randomString"))
            return getRandomString();
        else
        return  variableSheet.getStringCellValue(variableName,"Variable Value");
    }
    public List<String> getVariableValues(String variableName)
    {

            return  variableSheet.getStringCellValue(variableName);
    }

    public String getRandomString()
    {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

}
