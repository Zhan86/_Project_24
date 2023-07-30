package org.example;

public enum StudyProfile {
    MATHEMATICS ("Математика"),
    PHYSICS ("Физика"),
    MEDICINE("Медицина"),
    ENGINEERING("Инженерия"),
    COMPUTER_SCIENCE("Информатика"),
    LAW("Право"),
    ECONOMICS("Экономика");

    private String profileName;


    StudyProfile(String profileName) {
        this.profileName = profileName;
    }


    public String getProfileName() {
        return profileName;
    }
}
