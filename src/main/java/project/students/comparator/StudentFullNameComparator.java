package project.students.comparator;

import org.apache.commons.lang3.StringUtils;
import project.students.comparator.StudentComparator;
import project.students.comparator.StudentScoreComparator;
import project.students.model.Student;

public class StudentFullNameComparator extends StudentScoreComparator implements StudentComparator {
    @Override
    public int compare(Student s1, Student s2) {
        return StringUtils.compare(s1.getFullName(), s2.getFullName());

    }
}
