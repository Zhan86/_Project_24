package org.example;

public class Main {
    public static void main(String[] args) {


        University university = new University("1", "Московский физико-технический институт", "МФТИ", 1951, StudyProfile.PHYSICS);

        Student student = new Student("Иванов Иван", "1", 2, 4.8f);

        System.out.println(university);
        System.out.println(student);
    }
    }
