package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

        students.forEach(System.out::println);
        universities.forEach(System.out::println);



        // Сериализация коллекций в JSON и вывод в консоль
        String studentsJson = JsonUtil.studentListToJson(students);
        String universitiesJson = JsonUtil.universityListToJson(universities);

        System.out.println("\nSerialized Students JSON:");
        System.out.println(studentsJson);

        System.out.println("\nSerialized Universities JSON:");
        System.out.println(universitiesJson);

        // Десериализация JSON строк обратно в коллекции
        List<Student> deserializedStudents = JsonUtil.jsonToStudentList(studentsJson);
        List<University> deserializedUniversities = JsonUtil.jsonToUniversityList(universitiesJson);

        // Сравнение количества элементов в исходных и десериализованных коллекциях
        System.out.println("\nOriginal Students Collection Size: " + students.size());
        System.out.println("Deserialized Students Collection Size: " + deserializedStudents.size());

        System.out.println("\nOriginal Universities Collection Size: " + universities.size());
        System.out.println("Deserialized Universities Collection Size: " + deserializedUniversities.size());


        // Сериализация и десериализация с использованием Stream API
        System.out.println("\nSerializing and deserializing using Stream API");
        List<String> serializedStudentsAPI = students.stream()
                .map(JsonUtil::studentToJson)
                .toList();

        List<String> serializedUniversitiesAPI = universities.stream()
                .map(JsonUtil::universityToJson)
                .toList();

        System.out.println("\nSerialized Students JSON using Stream API:");

        serializedStudentsAPI.forEach(System.out::println);

        System.out.println("\nSerialized Universities JSON using Stream API:");
        serializedUniversitiesAPI.forEach(System.out::println);

        // Десериализация и вывод десериализованных объектов
        List<Student> deserializedStudentsAPI = serializedStudentsAPI.stream()
                .map(json -> JsonUtil.jsonToStudent(json, Student.class))
                .toList();

        List<University> deserializedUniversitiesAPI = serializedUniversitiesAPI.stream()
                .map(json -> JsonUtil.jsonToUniversity(json, University.class))
                .toList();

        System.out.println("\nDeserialized Students using Stream API:");
        deserializedStudentsAPI.forEach(System.out::println);

        System.out.println("\nDeserialized Universities using Stream API:");
        deserializedUniversitiesAPI.forEach(System.out::println);


        // Создаем статистику
        List<Statistics> statisticsList = StatisticsUtils.generateStatistics(students, universities);

        // Генерируем и записываем XLSX-файл
        XlsWriter.generateAndWriteTable(statisticsList, "statistics.xlsx");


        System.out.println("Data reading and printing successful");
    } catch (IOException e) {
        System.out.println("Error reading file: " + e.getMessage());
    }




        }
    }

