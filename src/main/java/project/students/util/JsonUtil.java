package project.students.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import project.students.model.Student;
import project.students.model.University;


import java.util.List;

public final class JsonUtil {

    private JsonUtil() {

    }

    public static String studentToJson(Student student) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(student);
    }

    public static String universityToJson(University university) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(university);
    }

    public static Student jsonToStudent(String json, Class<Student> studentClass) {
        return new Gson().fromJson(json, Student.class);
    }

    public static University jsonToUniversity(String json, Class<University> universityClass) {
        return new Gson().fromJson(json, University.class);
    }


    public static String studentListToJson(List<Student> students) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(students);
    }

    public static String universityListToJson(List<University> universities) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(universities);
    }

    public static List<Student> jsonToStudentList(String json) {
        return new Gson().fromJson(json, new TypeToken<List<Student>>() {}.getType());
    }

    public static List<University> jsonToUniversityList(String json) {
        return new Gson().fromJson(json, new TypeToken<List<University>>() {}.getType());
    }

    public static String writeListToJson(List<?> list) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(list);
    }


    /*


    public static String toJsonCollection(Collection<?> collection) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(collection);
    }

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> List<T> fromJsonCollection(String json, Class<T> elementType) {
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, elementType);
        try {
            return objectMapper.readValue(json, type);
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

     */
}
