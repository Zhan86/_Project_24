package project.students.comparator;

import project.students.comparator.UniversityComparator;
import project.students.model.University;

public class UniversityYearComparator implements UniversityComparator {
    @Override
    public int compare(University u1, University u2) {
        return Integer.compare(u1.getYearOfFoundation(), u2.getYearOfFoundation());
    }
}