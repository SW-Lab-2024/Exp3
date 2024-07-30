package classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BookTest {

    @Test
    @DisplayName("Test Book constructor and getters")
    public void testBookConstructorAndGetters() {
        Book book = new Book("Title", "Author", 1);
        Assertions.assertEquals("Title", book.getTitle());
        Assertions.assertEquals("Author", book.getAuthor());
        Assertions.assertEquals(1, book.getId());
    }
}
