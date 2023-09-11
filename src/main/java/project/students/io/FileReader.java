package project.students.io;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import project.students.enums.StudyProfile;
import project.students.model.Student;
import project.students.model.University;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileReader {

    private static final Logger logger = Logger.getLogger(FileReader.class.getName());


    public static List<Student> readStudentsFromExcel(String filePath) throws IOException {
        List<Student> students = new ArrayList<>();

        try (FileInputStream fileInputStream = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {

            logger.log(Level.INFO, "Excel file reading started");

            Sheet sheet = workbook.getSheetAt(0); // Первый лист

            // Пропускаем заголовок
            Iterator<Row> iterator = sheet.iterator();
            if (iterator.hasNext()) {
                iterator.next();
            }

            // Перебор строк
            while (iterator.hasNext()) {
                Row row = iterator.next();

                Cell fullNameCell = row.getCell(0);
                Cell universityIdCell = row.getCell(1);
                Cell currentCourseCell = row.getCell(2);
                Cell avgExamScoreCell = row.getCell(3);

                String fullName = fullNameCell.getStringCellValue();
                String universityId = universityIdCell.getStringCellValue();
                int currentCourse = (int) currentCourseCell.getNumericCellValue();
                float avgExamScore = (float) avgExamScoreCell.getNumericCellValue();

                students.add(new Student(fullName, universityId, currentCourse, avgExamScore));
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Excel file reading failed", e);
            return students;
        }
        logger.log(Level.INFO, "Excel file reading finished successfully");


        return students;
    }

    // Аналогичный метод для чтения университетов

    public static List<University> readUniversitiesFromExcel(String filePath) throws IOException {
        List<University> universities = new ArrayList<>();

        try (FileInputStream fileInputStream = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {

            logger.log(Level.INFO, "Excel file reading started");

            Sheet sheet = workbook.getSheetAt(1); // Второй лист

            // Пропускаем заголовок
            Iterator<Row> iterator = sheet.iterator();
            if (iterator.hasNext()) {
                iterator.next();
            }

            // Перебор строк
            while (iterator.hasNext()) {
                Row row = iterator.next();

                Cell idCell = row.getCell(0);
                Cell fullNameCell = row.getCell(1);
                Cell shortNameCell = row.getCell(2);
                Cell yearOfFoundationCell = row.getCell(3);
                Cell mainProfileCell = row.getCell(4);

                String id = idCell.getStringCellValue();
                String fullName = fullNameCell.getStringCellValue();
                String shortName = shortNameCell.getStringCellValue();
                int yearOfFoundation = (int) yearOfFoundationCell.getNumericCellValue();
                StudyProfile mainProfile = StudyProfile.valueOf(mainProfileCell.getStringCellValue());

                universities.add(new University(id, fullName, shortName, yearOfFoundation, mainProfile));
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Excel file reading failed", e);
            return universities;
        }
        logger.log(Level.INFO, "Excel file reading finished successfully");

        return universities;
    }
}