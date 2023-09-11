package project.students.comparator;

import project.students.comparator.StudentComparator;
import project.students.model.Student;

public class StudentCourseComparator implements StudentComparator {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getCurrentCourseNumber(), s2.getCurrentCourseNumber());
    }
}