package classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StudentTest {
    private Student student;

    @BeforeEach
    public void setUp() {
        student = new Student("Name", 1);
    }

    @Test
    @DisplayName("Test Student constructor and getters")
    public void testStudentConstructorAndGetters() {
        Assertions.assertEquals("Name", student.getName());
        Assertions.assertEquals(1, student.getId());
    }

    @Test
    @DisplayName("Test Student toString method")
    public void testToString() {
        Assertions.assertEquals("Name|1", student.toString());
    }

    @Test
    @DisplayName("Test matches method with ID")
    public void testMatchesWithId() {
        Assertions.assertTrue(student.matches(SearchByType.ID, 1));
        Assertions.assertFalse(student.matches(SearchByType.ID, 2));
    }

    @Test
    @DisplayName("Test matches method with Name")
    public void testMatchesWithName() {
        Assertions.assertTrue(student.matches(SearchByType.NAME, "Name"));
        Assertions.assertFalse(student.matches(SearchByType.NAME, "Other"));
    }

    @Test
    @DisplayName("Test matches method with invalid key type")
    public void testMatchesWithInvalidKeyType() {
        Student student = new Student("Name", 1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> student.matches(SearchByType.ID, "invalid"));
    }

    @Test
    @DisplayName("Test addBook and hasBook methods")
    public void testAddBookAndHasBook() {
        Student student = new Student("Name", 1);
        Book book = new Book("Title", "Author", 1);
        Assertions.assertFalse(student.hasBook(book));
        student.addBook(book);
        Assertions.assertTrue(student.hasBook(book));
    }
}
