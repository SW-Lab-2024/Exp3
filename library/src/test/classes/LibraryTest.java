package test.classes;

import main.classes.Book;
import main.classes.Library;
import main.classes.SearchByType;
import main.classes.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LibraryTest {
    private Library library;
    private Book book;
    private Student student;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book = new Book("Book-1", "Author-1", 1);
        student = new Student("Student-1", 1);
        library.addBook(book);
        library.addStudent(student);
    }

    /*
     * Begin of lendBook test block
     */

    @Test
    @DisplayName("lendBook happy day!")
    public void lendBookHappyDayTest() {
        Assertions.assertTrue(library.lendBook(book, student));
        Assertions.assertTrue(library.hasStudent(student));
        Assertions.assertFalse(library.hasBook(book));
        Assertions.assertTrue(student.hasBook(book));
    }

    @Test
    @DisplayName("lendBook when the library does not have the book.")
    public void lendBookWhenLibraryDoesNotHaveBook() {
        Book book = new Book("Book-1", "Author-1", 1);
        Assertions.assertFalse(library.lendBook(book, student));
        Assertions.assertTrue(library.hasStudent(student));
        Assertions.assertFalse(library.hasBook(book));
        Assertions.assertFalse(student.hasBook(book));
    }

    @Test
    @DisplayName("lendBook when the library does not have the student.")
    public void lendBookWhenLibraryDoesNotHaveStudent() {
        Student student = new Student("Student-1", 1);
        Assertions.assertFalse(library.lendBook(book, student));
        Assertions.assertFalse(library.hasStudent(student));
        Assertions.assertTrue(library.hasBook(book));
        Assertions.assertFalse(student.hasBook(book));
    }

    @Test
    @DisplayName("lendBook when the student has the book already.")
    public void lendBookWhenStudentHasBookAlready() {
        student.addBook(book);
        Assertions.assertFalse(library.lendBook(book, student));
        Assertions.assertTrue(library.hasStudent(student));
        Assertions.assertTrue(library.hasBook(book));
        Assertions.assertTrue(student.hasBook(book));
    }

    /*
     * End of lendBook test block
     */

    /*
     * Begin of returnBook test block
     */

    @Test
    @DisplayName("returnBook happy day!")
    public void returnBookHappyDayTest() {
        student.addBook(book);
        Assertions.assertTrue(library.returnBook(book, student));
        Assertions.assertTrue(library.hasStudent(student));
        Assertions.assertTrue(library.hasBook(book));
        Assertions.assertFalse(student.hasBook(book));
    }

    @Test
    @DisplayName("returnBook when the library does not have the student.")
    public void returnBookWhenLibraryDoesNotHaveStudent() {
        Library library = new Library();
        Book book = new Book("Book-1", "Author-1", 1);
        Student student = new Student("Student-1", 1);
        student.addBook(book);
        Assertions.assertFalse(library.returnBook(book, student));
        Assertions.assertFalse(library.hasStudent(student));
        Assertions.assertFalse(library.hasBook(book));
        Assertions.assertTrue(student.hasBook(book));
    }

    @Test
    @DisplayName("returnBook when the student does not have the book.")
    public void returnBookWhenStudentDoesNotHaveBook() {
        Library library = new Library();
        Book book = new Book("Book-1", "Author-1", 1);
        Student student = new Student("Student-1", 1);
        library.addStudent(student);
        Assertions.assertFalse(library.returnBook(book, student));
        Assertions.assertTrue(library.hasStudent(student));
        Assertions.assertFalse(library.hasBook(book));
        Assertions.assertFalse(student.hasBook(book));
    }

    /*
     * End of returnBook test block
     */

    /*
     * Begin of searchBooks test block
     */

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

    @Test
    @DisplayName("Throw exception when key's type does not match with search type")
    public void searchBooksKeyTypeNotMatchSearchType() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> library.searchBooks(SearchByType.ID, createKeys("book1", 1)));
    }

    /*
     * End of searchBooks test block
     */

    /*
     * Begin of searchStudents test block
     */

    @Test
    @DisplayName("searchStudents must return null when no student is found")
    public void searchStudentsNoStudentFound() {
        Library library = new Library();
        ArrayList<Object> keys = new ArrayList<>(List.of(1));
        Assertions.assertNull(library.searchStudents(SearchByType.ID, keys));
    }

    /*
     * End of searchStudent test block
     */
}
