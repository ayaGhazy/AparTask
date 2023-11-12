package objectRepository;

import csv.CSVReaderManager;
import csv.IReader;
import utilites.EnumClass;
import utilites.Global;

public class ObjectRepositoryMapper  {
        final IReader objectRepositoryMapper;
    public ObjectRepositoryMapper(String filePath,String fileName) {
        objectRepositoryMapper= CSVReaderManager.getInstance(filePath, fileName);
    }

    public ObjectRepositoryMapper() {

          String  fileName= Global.getProperty("ObjectRepositorySheetName");
          String filePath=Global.getProperty("ObjectRepositoryFilePath");
        objectRepositoryMapper=CSVReaderManager.getInstance(filePath, fileName);

    }
    // load all rows

    //colname based on ios wala android
    public  String getFindBy(String elementName)
    {
        return  objectRepositoryMapper.getStringCellValue(elementName, EnumClass.ObjectRepository.findBy.getElementValue());
    }
    public  String getValue(String elementName)
    {
        return   objectRepositoryMapper.getStringCellValue(elementName, EnumClass.ObjectRepository.value.getElementValue());
    }


}
