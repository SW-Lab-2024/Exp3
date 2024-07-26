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
        Book book = new Book("Book-1", "Author-1", 1);
        library.addBook(book);
    }

    private Book assertIsAnythingReturned(SearchByType searchByType, ArrayList<Object> keys) {
        ArrayList<Book> result = library.searchBooks(searchByType, keys);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
        return result.get(0);
    }

    private ArrayList<Object> createKeys(Object... keys) {
        return new ArrayList<>(List.of(keys));
    }

    @Test
    @DisplayName("searchBooks must return null when no book is found")
    public void searchBooksNoBookFound() {
        ArrayList<Object> keys = createKeys(100);
        Assertions.assertNull(library.searchBooks(SearchByType.ID, keys));
    }

    @Test
    @DisplayName("searchBooks must throw an exception when search is by name")
    public void searchBooksSearchByName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> library.searchBooks(SearchByType.NAME, createKeys("Book-1")));
    }

    @Test
    @DisplayName("Return some books when search matches with type of id")
    public void searchBooksSearchById() {
        Assertions.assertEquals(1, assertIsAnythingReturned(SearchByType.ID, createKeys(1)).getId());
    }

    @Test
    @DisplayName("Return some books when search matches with type of author")
    public void searchBooksSearchByAuthor() {
        Assertions.assertEquals("Author-1", assertIsAnythingReturned(SearchByType.AUTHOR, createKeys("Author-1")).getAuthor());
    }

    @Test
    @DisplayName("Return some books when search matches with type of title")
    public void searchBooksSearchByTitle() {
        Assertions.assertEquals("Book-1", assertIsAnythingReturned(SearchByType.TITLE, createKeys("Book-1")).getTitle());

    }
}
