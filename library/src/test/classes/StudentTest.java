package classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StudentTest {

    @Test
    @DisplayName("Test Student constructor and getters")
    public void testStudentConstructorAndGetters() {
        Student student = new Student("Name", 1);
        Assertions.assertEquals("Name", student.getName());
        Assertions.assertEquals(1, student.getId());
    }

    @Test
    @DisplayName("Test Student toString method")
    public void testToString() {
        Student student = new Student("Name", 1);
        Assertions.assertEquals("Name|1", student.toString());
    }
}
