package csv;

import java.util.List;
import java.util.Map;

public interface IReader {


    public String getStringCellValue(int rowNo, int i);

    public String getStringCellValue(String rowName, String colName);

    public int getLastRowNo();

    public int getLastCoulmnNo();

    public List testcaseId();


    public String getStringCellValue(int rowNo, String colName);

    public void setMapColumnNames();

    List getRows();

    List<String> getStringCellValue(String variableName);
}
