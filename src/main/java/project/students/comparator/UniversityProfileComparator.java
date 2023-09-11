package project.students.comparator;

import project.students.comparator.UniversityComparator;
import project.students.model.University;

public class UniversityProfileComparator implements UniversityComparator {
    @Override
    public int compare(University u1, University u2) {
        return u1.getMainProfile().compareTo(u2.getMainProfile());
    }
}