package test.classes;

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
        ArrayList<Object> keys = new ArrayList<>(List.of("Boostan"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> library.searchBooks(SearchByType.NAME, keys));
    }
}
