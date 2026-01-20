package com.restAssured.tests.utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtils {

    public static Object[][] getExcelData(String filePath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        List<Object[]> data = new ArrayList<>();

        Iterator<Row> rows = sheet.iterator();
        rows.next();

        while (rows.hasNext()) {
            Row row = rows.next();
            String summary = row.getCell(0).getStringCellValue();
            String description = row.getCell(1).getStringCellValue();
            String projectId = row.getCell(2).getStringCellValue();

            data.add(new Object[]{summary, description, projectId});
        }

        workbook.close();
        fis.close();

        return data.toArray(new Object[0][]);
    }
}
