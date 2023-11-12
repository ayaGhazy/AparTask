package csv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import org.apache.commons.lang3.StringUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVReaderManager  implements IReader{
    String filePath;
    String fileName;
    private static CSVReaderManager csvReader;

     Map<String, Integer> coulmnMap=new TreeMap() ;
    List<String[]> csvRows=new ArrayList();
    protected CSVReaderManager(String filePath, String fileName) {
        this.filePath = filePath;
        this.fileName = fileName;
    }
    public static CSVReaderManager getInstance(String filePath, String fileName) {

            csvReader = new CSVReaderManager(filePath, fileName);


        return csvReader;
    }
    public void setRows()
    {
        CSVReader reader = null;
        try {
             reader = new CSVReader(new FileReader(filePath+"/"+fileName));
            csvRows= reader.readAll();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            e.printStackTrace();
        }

    }

    public List<String[]> getRows()
    {
        if(csvRows==null || csvRows.isEmpty())
            setRows();
        return csvRows;
    }

    
    public int getLastCoulmnNo()
    {
       return getRows().get(0).length;
    }
    
    public  int getLastRowNo()
    {
        return getRows().size();
    }

    public void setMapColumnNames()
    {

         String[] col=getRows().get(0);
         for(int i=0;i< col.length ;i++)
         {
             coulmnMap.put(col[i].trim(),i);
         }
    }
    
    public List testcaseId()
    {
        List <String> ids= new ArrayList();
        String[] col=getRows().get(1);
        for(String id : col)
        {
            ids.add(id);
        }
        return ids;
    }
    public Map<String, Integer> getCoulmnMap()
    {

        if(coulmnMap==null || coulmnMap.isEmpty())
            setMapColumnNames();
        return coulmnMap;
    }
    
    public String getStringCellValue(String rowName, String colName) {
        int colNo= getCoulmnMap().get(colName);
        int rowNo= getFirstCoulmnsName().get(rowName);
       return getStringCellValue(rowNo,colNo);
    }
    public List<String> getStringCellValue(String rowName) {
        List<String> result  = new ArrayList<>();
        int colLastNo= getLastCoulmnNo();
        int rowNo= getFirstCoulmnsName().get(rowName);
        for (int colNo=1;colNo<colLastNo;colNo++)
            result.add(getStringCellValue(rowNo,colNo));
        return result;
    }
    public String getStringCellValue(int rowId, int colId) {
//        try {
        String value = getRows().get(rowId)[colId];
        value=(StringUtils.defaultString(value)=="0")?"":StringUtils.defaultString(value).replaceAll("\\\"\\s+\\\"","\\\"\\s\\\"");
        return value;
    }
    public String getStringCellValue(int rowId, String colName) {
//        try {
        Map<String,Integer> columns= getCoulmnMap();
        try{
            int colId = columns.get(colName.trim());
       List<String[]> rows= getRows();
        String[] row=  rows.get(rowId);
        String value= row[colId];
        return value;

            }
        catch (NullPointerException e)
        {
            return "";
        }
    }
    public  Map<String,Integer> getFirstCoulmnsName()
    {
        Map<String,Integer> list= new HashMap();
        int rows=  getRows().size();
        for(int i=1;i<rows;i++)
            list.put(  getRows().get(i)[0],i);
        return list;
    }
    public static void main(String[] args)
    {
     CSVReaderManager reader = new CSVReaderManager("C:\\Users\\a818438\\IdeaProjects\\testing-automation-pilot1\\src\\test\\resources"
     ,"test.csv");
     reader.getRows();
    }
    }
