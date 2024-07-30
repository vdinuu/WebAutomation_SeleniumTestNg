package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ExcelUtil {
    public static Map<String, Map<String, String>> getExcelData(String path, String sheetName) throws IOException {
        List<String> columnHeader = new ArrayList<>();
        Map<String, String> rowDataMap;
        Map<String, Map<String, String>> testDataMap = new HashMap<>();
        FileInputStream inputStream = new FileInputStream(path);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(0);
        Iterator<Cell> cellIterator = row.iterator();
        while (cellIterator.hasNext()) {
            columnHeader.add(cellIterator.next().getStringCellValue());
        }
        int rowCount = sheet.getLastRowNum();
        int columnCount = row.getLastCellNum();
        String testCaseName = "";
        for (int i = 1; i <= rowCount; i++) {
            Row row1 = sheet.getRow(i);
            rowDataMap = new HashMap<>();
            for (int j = 0; j < columnCount; j++) {
                if (j == 0) {
                    Cell cell = row1.getCell(j);
                    testCaseName = cell.getStringCellValue().trim();
                } else {
                    Cell cell = row1.getCell(j);
                    rowDataMap.put(columnHeader.get(j), cell.getStringCellValue().trim());
                }
            }
            testDataMap.put(testCaseName, rowDataMap);
        }
        return testDataMap;
    }
}
