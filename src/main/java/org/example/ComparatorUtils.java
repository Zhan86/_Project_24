package org.example;

import java.util.Comparator;


public class ComparatorUtils {
    public static Comparator<Student> getStudentComparator(StudentComparatorType comparatorType) {
        switch (comparatorType) {
            case FULL_NAME:
                return new StudentFullNameComparator();
            case COURSE:
                return new StudentCourseComparator();
            case SCORE:
                return new StudentScoreComparator();
            default:
                throw new IllegalArgumentException("Unknown comparator type for Student: " + comparatorType);
        }
    }

    public static Comparator<University> getUniversityComparator(UniversityComparatorType comparatorType) {
        switch (comparatorType) {
            case FULL_NAME:
                return new UniversityFullNameComparator();
            case SHORT_NAME:
                return new UniversityShortNameComparator();
            case YEAR:
                return new UniversityYearComparator();
            case MAIN_PROFILE:
                return new UniversityProfileComparator();
            default:
                throw new IllegalArgumentException("Unknown comparator type for University: " + comparatorType);
        }
    }
}
