package org.example;

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
