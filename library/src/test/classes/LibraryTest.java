package classes;

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

    @Test
    @DisplayName("Test addBook and hasBook methods")
    public void testAddBookAndHasBook() {
        Book newBook = new Book("Book-2", "Author-2", 2);
        Assertions.assertFalse(library.hasBook(newBook));
        library.addBook(newBook);
        Assertions.assertTrue(library.hasBook(newBook));
    }

    @Test
    @DisplayName("Test addStudent and hasStudent methods")
    public void testAddStudentAndHasStudent() {
        Student newStudent = new Student("Student-2", 2);
        Assertions.assertFalse(library.hasStudent(newStudent));
        library.addStudent(newStudent);
        Assertions.assertTrue(library.hasStudent(newStudent));
    }

    @Test
    @DisplayName("Test lendBook method")
    public void testLendBook() {
        Assertions.assertTrue(library.lendBook(book, student));
        Assertions.assertFalse(library.hasBook(book));
        Assertions.assertTrue(student.hasBook(book));
    }

    @Test
    @DisplayName("Test lendBook when book is not in library")
    public void testLendBookNotInLibrary() {
        Book newBook = new Book("Book-2", "Author-2", 2);
        Assertions.assertFalse(library.lendBook(newBook, student));
    }

    @Test
    @DisplayName("Test lendBook when student is not in library")
    public void testLendBookStudentNotInLibrary() {
        Student newStudent = new Student("Student-2", 2);
        Assertions.assertFalse(library.lendBook(book, newStudent));
    }

    @Test
    @DisplayName("Test lendBook when student already has the book")
    public void testLendBookStudentAlreadyHasBook() {
        student.addBook(book);
        Assertions.assertFalse(library.lendBook(book, student));
    }

    @Test
    @DisplayName("Test returnBook method")
    public void testReturnBook() {
        student.addBook(book);
        Assertions.assertTrue(library.returnBook(book, student));
        Assertions.assertTrue(library.hasBook(book));
        Assertions.assertFalse(student.hasBook(book));
    }

    @Test
    @DisplayName("Test returnBook when student is not in library")
    public void testReturnBookStudentNotInLibrary() {
        Library newLibrary = new Library();
        Book newBook = new Book("Book-1", "Author-1", 1);
        Student newStudent = new Student("Student-1", 1);
        newStudent.addBook(newBook);
        Assertions.assertFalse(newLibrary.returnBook(newBook, newStudent));
    }

    @Test
    @DisplayName("Test returnBook when student does not have the book")
    public void testReturnBookStudentDoesNotHaveBook() {
        Assertions.assertFalse(library.returnBook(book, student));
    }

    @Test
    @DisplayName("Test displayBooks method")
    public void testDisplayBooks() {
        library.displayBooks();
    }

    @Test
    @DisplayName("Test displayStudents method")
    public void testDisplayStudents() {
        library.displayStudents();
    }

    @Test
    @DisplayName("Test searchBooks method with no matching book")
    public void testSearchBooksNoMatchingBook() {
        ArrayList<Object> keys = new ArrayList<>();
        keys.add("NonExistingBook");
        Assertions.assertNull(library.searchBooks(SearchByType.TITLE, keys));
    }

    @Test
    @DisplayName("Test searchBooks method with matching ID")
    public void testSearchBooksById() {
        ArrayList<Object> keys = new ArrayList<>();
        keys.add(1);
        ArrayList<Book> result = library.searchBooks(SearchByType.ID, keys);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(book, result.get(0));
    }

    @Test
    @DisplayName("Test searchBooks method with matching title")
    public void testSearchBooksByTitle() {
        ArrayList<Object> keys = new ArrayList<>();
        keys.add("Book-1");
        ArrayList<Book> result = library.searchBooks(SearchByType.TITLE, keys);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(book, result.get(0));
    }

    @Test
    @DisplayName("Test searchBooks method with matching author")
    public void testSearchBooksByAuthor() {
        ArrayList<Object> keys = new ArrayList<>();
        keys.add("Author-1");
        ArrayList<Book> result = library.searchBooks(SearchByType.AUTHOR, keys);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(book, result.get(0));
    }

    @Test
    @DisplayName("Test searchBooks method with invalid search type")
    public void testSearchBooksInvalidSearchType() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> library.searchBooks(SearchByType.NAME, createKeys("Book-1")));
    }

    @Test
    @DisplayName("Test searchStudents method with no matching student")
    public void testSearchStudentsNoMatchingStudent() {
        ArrayList<Object> keys = new ArrayList<>();
        keys.add(100);
        Assertions.assertNull(library.searchStudents(SearchByType.ID, keys));
    }

    @Test
    @DisplayName("Test searchStudents method with matching ID")
    public void testSearchStudentsById() {
        ArrayList<Object> keys = new ArrayList<>();
        keys.add(1);
        ArrayList<Student> result = library.searchStudents(SearchByType.ID, keys);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(student, result.get(0));
    }

    @Test
    @DisplayName("Test searchStudents method with matching name")
    public void testSearchStudentsByName() {
        ArrayList<Object> keys = new ArrayList<>();
        keys.add("Student-1");
        ArrayList<Student> result = library.searchStudents(SearchByType.NAME, keys);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(student, result.get(0));
    }

    @Test
    @DisplayName("Test searchStudents method with invalid search type")
    public void testSearchStudentsInvalidSearchType() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> library.searchStudents(SearchByType.TITLE, createKeys("Student-1")));
    }

    private ArrayList<Object> createKeys(Object... keys) {
        return new ArrayList<>(List.of(keys));
    }
}
