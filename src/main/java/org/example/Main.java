package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import static org.example.FileReader.readStudentsFromExcel;
import static org.example.FileReader.readUniversitiesFromExcel;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {  try {
        List<Student> students = readStudentsFromExcel("src/main/resources/universityInfo.xlsx");
        List<University> universities = readUniversitiesFromExcel("src/main/resources/universityInfo.xlsx");

        Comparator<Student> studentComparator = ComparatorUtils.getStudentComparator(StudentComparatorType.SCORE);
        students.sort(studentComparator);

        Comparator<University> universityComparator = ComparatorUtils.getUniversityComparator(UniversityComparatorType.FULL_NAME);
        universities.sort(universityComparator);

        students.stream().forEachOrdered(System.out::println);
        universities.stream().forEachOrdered(System.out::println);

        System.out.println("Data reading and printing successful");
    } catch (IOException e) {
        System.out.println("Error reading file: " + e.getMessage());
    }

        }
    }

