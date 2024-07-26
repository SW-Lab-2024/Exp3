package test.classes;

import main.classes.Book;
import main.classes.Library;
import main.classes.SearchByType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

public class LibraryTest {
    private Library library;

    @BeforeEach
    public void setUp() {
        library = new Library();
    }

    private ArrayList<Object> createKeys(Object... keys) {
        return new ArrayList<>(List.of(keys));
    }

    @Test
    @DisplayName("searchBooks must return null when no book is found")
    public void searchBooksNoBookFound() {
        ArrayList<Object> keys = createKeys(1);
        Assertions.assertNull(library.searchBooks(SearchByType.ID, keys));
    }

    @Test
    @DisplayName("searchBooks must throw an exception when search is by name")
    public void searchBooksSearchByName() {
        ArrayList<Object> keys = createKeys("Book-1");
        Assertions.assertThrows(IllegalArgumentException.class, () -> library.searchBooks(SearchByType.NAME, keys));
    }

    @Test
    @DisplayName("Return some books when search matches with type of id")
    public void searchBooksSearchById() {
        ArrayList<Object> keys = createKeys(1);
        Book book1 = new Book("Book-1", "Author-1", 1);
        library.addBook(book1);
        ArrayList<Book> result = library.searchBooks(SearchByType.ID, keys);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(book1, result.get(0));
    }

    @Test
    @DisplayName("Return some books when search matches with type of author")
    public void searchBooksSearchByAuthor() {
        ArrayList<Object> keys = createKeys("Author-1");
        Book book1 = new Book("Book-1", "Author-1", 1);
        library.addBook(book1);
        ArrayList<Book> result = library.searchBooks(SearchByType.TITLE, keys);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(book1, result.get(0));
    }
}
