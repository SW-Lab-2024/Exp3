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
    @DisplayName("No book found in searching books")
    public void searchBooksNoBookFound() {
        Library library = new Library();
        ArrayList<Object> keys = new ArrayList<>(List.of(1));
        Assertions.assertNull(library.searchBooks(SearchByType.ID, keys));
    }

}
