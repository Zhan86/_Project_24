package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XlsWriter {

    public static void generateAndWriteTable(List<Statistics> statisticsList, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Statistics");

            // делаем заголовки жирным
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 14);
            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);

            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Study Profile");
            headerRow.createCell(1).setCellValue("Average Exam Score");
            headerRow.createCell(2).setCellValue("Student Count");
            headerRow.createCell(3).setCellValue("University Count");
            headerRow.createCell(4).setCellValue("University Names");

            for (int i = 0; i < 5; i++) {
                headerRow.getCell(i).setCellStyle(headerCellStyle);
            }

            // заполняем данные
            int rowNum = 1;
            for (Statistics statistics : statisticsList) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(statistics.getStudyProfile().getProfileName());
                row.createCell(1).setCellValue(statistics.getAverageExamScore());
                row.createCell(2).setCellValue(statistics.getStudentCount());
                row.createCell(3).setCellValue(statistics.getUniversityCount());
                row.createCell(4).setCellValue(String.join(", ", statistics.getUniversityNames()));
            }

            // раздвигаем столбцы по размеру
            for (int i = 0; i < 5; i++) {
                sheet.autoSizeColumn(i);
            }

            // пишем в файл
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
