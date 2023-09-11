package project.students.util;
import project.students.model.Statistics;
import project.students.model.Student;
import project.students.enums.StudyProfile;
import project.students.model.University;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class StatisticsUtils {

    public static List<Statistics> generateStatistics(List<Student> students, List<University> universities) {
        Map<String, List<Student>> studentsByUniversity = students.stream()
                .collect(Collectors.groupingBy(Student::getUniversityId));

        Map<StudyProfile, List<University>> universitiesByProfile = universities.stream()
                .collect(Collectors.groupingBy(University::getMainProfile));

        List<Statistics> statisticsList = new ArrayList<>();

        for (Map.Entry<StudyProfile, List<University>> entry : universitiesByProfile.entrySet()) {
            StudyProfile profile = entry.getKey();
            List<University> profileUniversities = entry.getValue();

            BigDecimal totalScore = BigDecimal.ZERO;
            int studentCount = 0;
            int universityCount = profileUniversities.size();
            List<String> universityNames = profileUniversities.stream()
                    .map(University::getFullName)
                    .collect(Collectors.toList());

            for (University university : profileUniversities) {
                List<Student> universityStudents = studentsByUniversity.getOrDefault(university.getId(), Collections.emptyList());
                studentCount += universityStudents.size();

                for (Student student : universityStudents) {
                    totalScore = totalScore.add(BigDecimal.valueOf(student.getAvgExamScore()));
                }
            }

            BigDecimal averageScore = BigDecimal.ZERO;
            if (studentCount > 0) {
                averageScore = totalScore.divide(BigDecimal.valueOf(studentCount), 2, RoundingMode.HALF_UP);
            }

            Statistics statistics = new Statistics(profile, averageScore.floatValue(), studentCount, universityCount, universityNames);
            statisticsList.add(statistics);
        }

        return statisticsList;
    }
}
