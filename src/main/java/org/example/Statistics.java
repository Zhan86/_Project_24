package org.example;
import java.math.BigDecimal;
import java.util.List;

public class Statistics {
    private StudyProfile studyProfile;
    private float averageExamScore;
    private int studentCount;
    private int universityCount;
    private List<String> universityNames;

    public Statistics(StudyProfile studyProfile, float averageExamScore, int studentCount, int universityCount, List<String> universityNames) {
        this.studyProfile = studyProfile;
        this.averageExamScore = averageExamScore;
        this.studentCount = studentCount;
        this.universityCount = universityCount;
        this.universityNames = universityNames;
    }

    public StudyProfile getStudyProfile() {
        return studyProfile;
    }

    public void setStudyProfile(StudyProfile studyProfile) {
        this.studyProfile = studyProfile;
    }

    public float getAverageExamScore() {
        return averageExamScore;
    }

    public void setAverageExamScore(float averageExamScore) {
        this.averageExamScore = averageExamScore;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public int getUniversityCount() {
        return universityCount;
    }

    public void setUniversityCount(int universityCount) {
        this.universityCount = universityCount;
    }

    public List<String> getUniversityNames() {
        return universityNames;
    }

    public void setUniversityNames(List<String> universityNames) {
        this.universityNames = universityNames;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "studyProfile=" + studyProfile +
                ", averageExamScore=" + averageExamScore +
                ", studentCount=" + studentCount +
                ", universityCount=" + universityCount +
                ", universityNames=" + universityNames +
                '}';
    }
}
