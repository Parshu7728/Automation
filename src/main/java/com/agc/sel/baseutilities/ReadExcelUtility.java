package com.agc.sel.baseutilities;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class ReadExcelUtility {

    /**
     * Reads the latest .xlsx file from a directory and returns its data as a List of Maps.
     * If you pass a file path instead of a folder path, it will read that file directly.
     *
     * @param path Folder path containing the Excel file OR direct Excel file path.
     */
    public static List<Map<String, String>> readExcelAsListofMaps() {
        List<Map<String, String>> dataList = new ArrayList<>();
         String  path = "E:/AutomationAGC/Automation/Pdfdownload";
        try {
            File fileOrDir = new File(path);
            File excelFile;

            // If path is a folder, get the latest .xlsx file inside it
            if (fileOrDir.isDirectory()) {
                File[] excelFiles = fileOrDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
                if (excelFiles == null || excelFiles.length == 0) {
                    throw new RuntimeException("No Excel files found in folder: " + path);
                }
                Arrays.sort(excelFiles, Comparator.comparingLong(File::lastModified).reversed());
                excelFile = excelFiles[0]; // latest file
            } else {
                excelFile = fileOrDir; // path is a file
            }

            try (FileInputStream fis = new FileInputStream(excelFile);
                 Workbook workbook = WorkbookFactory.create(fis)) {

                Sheet sheet = workbook.getSheetAt(0);
                Iterator<Row> rowIterator = sheet.iterator();

                // Read header row
                List<String> headers = new ArrayList<>();
                Row headerRow = rowIterator.next();
                for (Cell cell : headerRow) {
                    headers.add(cell.getStringCellValue().trim());
                }

                // Read data rows
                while (rowIterator.hasNext()) {
                    Row currentRow = rowIterator.next();
                    Map<String, String> rowMap = new LinkedHashMap<>();
                    for (int i = 0; i < headers.size(); i++) {
                        Cell cell = currentRow.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        cell.setCellType(CellType.STRING);
                        rowMap.put(headers.get(i), cell.getStringCellValue().trim());
                    }
                    dataList.add(rowMap);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataList;
    }
}
