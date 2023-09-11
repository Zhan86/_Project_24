package project.students.comparator;

import org.apache.commons.lang3.StringUtils;
import project.students.comparator.UniversityComparator;
import project.students.model.University;

public class UniversityShortNameComparator implements UniversityComparator {
    @Override
    public int compare(University u1, University u2) {
        return StringUtils.compare(u1.getShortName(), u2.getShortName());
    }
}
