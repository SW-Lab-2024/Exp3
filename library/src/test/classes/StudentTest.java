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

    @Test
    @DisplayName("Test matches method with ID")
    public void testMatchesWithId() {
        Student student = new Student("Name", 1);
        Assertions.assertTrue(student.matches(SearchByType.ID, 1));
        Assertions.assertFalse(student.matches(SearchByType.ID, 2));
    }

    @Test
    @DisplayName("Test matches method with Name")
    public void testMatchesWithName() {
        Student student = new Student("Name", 1);
        Assertions.assertTrue(student.matches(SearchByType.NAME, "Name"));
        Assertions.assertFalse(student.matches(SearchByType.NAME, "Other"));
    }
}
