package project.students;

import project.students.comparator.StudentComparator;
import project.students.comparator.UniversityComparator;
import project.students.enums.StudentComparatorType;
import project.students.enums.UniversityComparatorType;
import project.students.io.JsonWriter;
import project.students.io.FileReader;
import project.students.io.XlsWriter;
import project.students.io.XmlWriter;
import project.students.model.FullInfo;
import project.students.model.Statistics;
import project.students.model.Student;
import project.students.model.University;
import project.students.util.ComparatorUtils;
import project.students.util.StatisticsUtils;

import java.io.IOException;
import java.util.Date;
import java.util.Comparator;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {

        try {
            LogManager.getLogManager().readConfiguration(
                    Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }

        logger.log(INFO, "Application started, Logger configured");

        List<University> universities =
                FileReader.readUniversitiesFromExcel("src/main/resources/universityInfo.xlsx");
        Comparator<University> universityComparator = ComparatorUtils.getUniversityComparator(UniversityComparatorType.FULL_NAME);
        universities.sort(universityComparator);

        List<Student> students =
                FileReader.readStudentsFromExcel("src/main/resources/universityInfo.xlsx");
        Comparator<Student> studentComparator = ComparatorUtils.getStudentComparator(StudentComparatorType.SCORE);
        students.sort(studentComparator);

        List<Statistics> statisticsList = StatisticsUtils.generateStatistics(students, universities);
        XlsWriter.generateAndWriteTable(statisticsList, "statistics.xlsx");

        FullInfo fullInfo = new FullInfo()
                .setStudentList(students)
                .setUniversityList(universities)
                .setStatisticsList(statisticsList)
                .setProcessDate(new Date());

        XmlWriter.generateXmlReq(fullInfo);
        JsonWriter.writeJsonReq(fullInfo);

        logger.log(INFO, "Application finished");
    }
    }

