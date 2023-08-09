package org.example;

import java.util.Comparator;

public enum StudentComparatorType {
    FULL_NAME(new StudentFullNameComparator()),
    COURSE(new StudentCourseComparator()),
    SCORE(new StudentScoreComparator());

    private final Comparator<Student> comparator;

    StudentComparatorType(Comparator<Student> comparator) {
        this.comparator = comparator;
    }

    public Comparator<Student> getComparator() {
        return comparator;
    }
}