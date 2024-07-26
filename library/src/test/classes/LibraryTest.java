package test.classes;

import main.classes.Library;
import main.classes.SearchByType;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LibraryTest {
    @Test
    @DisplayName("searchBooks must return null when no book is found")
    public void searchBooksNoBookFound() {
        Library library = new Library();
        ArrayList<Object> keys = new ArrayList<>(List.of(1));
        Assertions.assertNull(library.searchBooks(SearchByType.ID, keys));
    }

    @Test
    @DisplayName("searchBooks must throw an exception when search is by name")
    public void searchBooksSearchByName() {
        Library library = new Library();
        ArrayList<Object> keys = new ArrayList<>(List.of("Boostan"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> library.searchBooks(SearchByType.NAME, keys));
    }
}
