package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() throws CloneNotSupportedException  {
        // Given
        Library library = new Library("Main Library");
        Book book1 = new Book("Book One", "Author A", LocalDate.of(2000, 5, 20));
        Book book2 = new Book("Book Two", "Author B", LocalDate.of(2010, 8, 15));
        Book book3 = new Book("Book Three", "Author C", LocalDate.of(2020, 1, 10));

        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);

        Library shallowClonedLibrary = library.shallowCopy();
        shallowClonedLibrary.setName("Deep Copy Library");

        Library deepClonedLibrary = library.deepCopy();
        deepClonedLibrary.setName("Deep Copy Library");

        // When
        library.getBooks().remove(book1);

        // Then
        assertEquals(2, library.getBooks().size());
        assertEquals(2, shallowClonedLibrary.getBooks().size());
        assertEquals(3, deepClonedLibrary.getBooks().size());

        assertTrue(shallowClonedLibrary.getBooks().contains(book2));
        assertTrue(deepClonedLibrary.getBooks().contains(book1));
    }
}
