package project.students.enums;

import project.students.comparator.UniversityFullNameComparator;
import project.students.comparator.UniversityProfileComparator;
import project.students.comparator.UniversityShortNameComparator;
import project.students.comparator.UniversityYearComparator;
import project.students.model.University;

import java.util.Comparator;

public enum UniversityComparatorType {
    FULL_NAME(new UniversityFullNameComparator()),
    SHORT_NAME (new UniversityShortNameComparator()),
    YEAR (new UniversityYearComparator()),
    MAIN_PROFILE (new UniversityProfileComparator());

    private final Comparator<University> comparator;

    UniversityComparatorType(Comparator<University> comparator) {
        this.comparator = comparator;
    }

    public Comparator<University> getComparator() {
        return comparator;
    }
}
