package classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BookTest {
    private Book book;

    @BeforeEach
    public void setUp() {
        book = new Book("Title", "Author", 1);
    }

    @Test
    @DisplayName("Test Book constructor and getters")
    public void testBookConstructorAndGetters() {
        Assertions.assertEquals("Title", book.getTitle());
        Assertions.assertEquals("Author", book.getAuthor());
        Assertions.assertEquals(1, book.getId());
    }

    @Test
    @DisplayName("Test Book toString method")
    public void testToString() {
        Assertions.assertEquals("Title by Author", book.toString());
    }

    @Test
    @DisplayName("Test matches method with ID")
    public void testMatchesWithId() {
        Assertions.assertTrue(book.matches(SearchByType.ID, 1));
        Assertions.assertFalse(book.matches(SearchByType.ID, 2));
    }

    @Test
    @DisplayName("Test matches method with Title")
    public void testMatchesWithTitle() {
        Assertions.assertTrue(book.matches(SearchByType.TITLE, "Title"));
        Assertions.assertFalse(book.matches(SearchByType.TITLE, "Other"));
    }

    @Test
    @DisplayName("Test matches method with Author")
    public void testMatchesWithAuthor() {
        Assertions.assertTrue(book.matches(SearchByType.AUTHOR, "Author"));
        Assertions.assertFalse(book.matches(SearchByType.AUTHOR, "Other"));
    }
}
