package Travel_Foly.Utils;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.DateUtil;
import org.openqa.selenium.By;

public class ExcelHelper {
    private FileInputStream fis;
    private FileOutputStream fileOut;
    private Workbook wb;
    private Sheet sh;
    private Cell cell;
    private Row row;
    private CellStyle cellstyle;
    private Color mycolor;
    private String excelFilePath;
    private Map<String, Integer> columns = new HashMap<>();

    public void setExcelFile(String ExcelPath, String SheetName) throws Exception {
        try {
            File f = new File(ExcelPath);

            if (!f.exists()) {
                f.createNewFile();
                System.out.println("File doesn't exist, so created!");
            }

            fis = new FileInputStream(ExcelPath);
            wb = WorkbookFactory.create(fis);
            sh = wb.getSheet(SheetName);
            //sh = wb.getSheetAt(0); //0 - index of 1st sheet
            if (sh == null) {
                sh = wb.createSheet(SheetName);
            }

            this.excelFilePath = ExcelPath;

            //adding all the column header names to the map 'columns'
            sh.getRow(0).forEach(cell ->{
                columns.put(cell.getStringCellValue(), cell.getColumnIndex());
            });

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getCellData(int rownum, int colnum) throws Exception{
        try{
            cell = sh.getRow(rownum).getCell(colnum);
            String CellData = null;
            switch (cell.getCellType()){
                case STRING:
                    CellData = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell))
                    {
                        CellData = String.valueOf(cell.getDateCellValue());
                    }
                    else
                    {
                        CellData = String.valueOf((long)cell.getNumericCellValue());
                    }
                    break;
                case BOOLEAN:
                    CellData = Boolean.toString(cell.getBooleanCellValue());
                    break;
                case BLANK:
                    CellData = "";
                    break;
            }
            return CellData;
        }catch (Exception e){
            return"";
        }
    }

    //Gọi ra hàm này nè
//        public String getCellData(String columnName, int rownum) throws Exception {
//            return getCellData(rownum, columns.get(columnName));
//        }

    public void setCellData(String text, int rownum, int colnum) throws Exception {
        try {
            row = sh.getRow(rownum);
            if (row == null) {
                row = sh.createRow(rownum);
            }
            cell = row.getCell(colnum);

            if (cell == null) {
                cell = row.createCell(colnum);
            }
            cell.setCellValue(text);

            fileOut = new FileOutputStream(excelFilePath);
            wb.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (Exception e) {
            throw (e);
        }
    }
    public String Regex(String data,int n){
        // Sử dụng biểu thức chính quy để tìm chuỗi sau dấu ":" thứ n
        Pattern pattern = Pattern.compile("^(?:[^:]*:){"+n+"}\\s*(.*)");
        Matcher matcher = pattern.matcher(data);

        // Kiểm tra nếu tìm thấy kết quả
        if (matcher.find()) {
            String result = matcher.group(1);
            return result;
        }
        return data;
    }
    public String RegexLoginWeb (String data,int n){
        // Sử dụng biểu thức chính quy để tìm chuỗi sau dấu ":" thứ n
        Pattern pattern = Pattern.compile("^(?:[^=]*=){" + n + "}\\s*(.*)");
        Matcher matcher = pattern.matcher(data);

        // Kiểm tra nếu tìm thấy kết quả
        if (matcher.find()) {
            String result = matcher.group(1);
            return result;
        }
        return data;
    }
    public By getLocator(String dataExcel) throws Exception {
        String locatorType = dataExcel.split(":")[0];
        String locatorValue = dataExcel.split(":")[1];
        // Return a instance of By class based on type of locator
        if (locatorType.toLowerCase().equals("id"))
            return By.id(locatorValue);
        else if (locatorType.toLowerCase().equals("name"))
            return By.name(locatorValue);
        else if ((locatorType.toLowerCase().equals("classname"))
                || (locatorType.toLowerCase().equals("class")))
            return By.className(locatorValue);
        else if ((locatorType.toLowerCase().equals("tagname"))
                || (locatorType.toLowerCase().equals("tag")))
            return By.className(locatorValue);
        else if ((locatorType.toLowerCase().equals("linktext"))
                || (locatorType.toLowerCase().equals("link")))
            return By.linkText(locatorValue);
        else if (locatorType.toLowerCase().equals("partiallinktext"))
            return By.partialLinkText(locatorValue);
        else if ((locatorType.toLowerCase().equals("cssselector"))
                || (locatorType.toLowerCase().equals("css")))
            return By.cssSelector(locatorValue);
        else if (locatorType.toLowerCase().equals("xpath"))
            return By.xpath(locatorValue);
        else
            throw new Exception("Locator type '" + locatorType
                    + "' not defined!!");
    }
}
