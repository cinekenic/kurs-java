package com.kodilla.testing.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookDirectoryTestSuite {

    private LibraryDatabase libraryDatabaseMock;

    @BeforeEach
    void setUp() {
        libraryDatabaseMock = mock(LibraryDatabase.class);
    }

    @Test
    void testListBooksWithConditionsReturnList() {
       //Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

        //When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");
    }

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    void testListBooksWithConditionMoreThan20() {

        // Given
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))
                .thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))
                .thenReturn(resultListOf40Books);

        // When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");
        // Then

        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test
    void testListBooksWithConditionFragmentShorterThan3() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        // When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        // Then
        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    void testListBooksInHandsOfWhenNoBooks() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        LibraryUser libraryUser = new LibraryUser("John", "Nowak", "123456789");
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(new ArrayList<>());

        //When
        List<Book> result = bookLibrary.listBooksInHandsOf(libraryUser);

        //Then
        assertEquals(0, result.size());
        verify(libraryDatabaseMock, times(1)).listBooksInHandsOf(libraryUser);
    }

    @Test
    void testListBooksInHandsOfWhenOneBook() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        LibraryUser libraryUser = new LibraryUser("John", "Nowak", "123456789");
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        List<Book> books = List.of(new Book("Secrets of Alamo", "John Smith", 2008));
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(books);

        //When
        List<Book> result = bookLibrary.listBooksInHandsOf(libraryUser);

        //Then
        assertEquals(1, result.size());
        assertEquals("Secrets of Alamo", result.get(0).getTitle());
        verify(libraryDatabaseMock, times(1)).listBooksInHandsOf(libraryUser);
    }

    @Test
    void testListBooksInHandsOfWhenFiveBooks() {
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        LibraryUser libraryUser = new LibraryUser("John", "Nowak", "123456789");
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

        List<Book> books = List.of(
        new Book("Secrets of Alamo", "John Smith", 2008),
        new Book("Secretaries and Directors", "Dilbert Michigan", 2012),
        new Book("Secret life of programmers", "Steve Wolkowitz", 2016),
        new Book("Secrets of Java", "Ian Tenewitch", 2010),
        new Book("Secrets of Java", "Ian Tenewitch", 2010)
        );
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(books);

        //When
        List<Book> result = bookLibrary.listBooksInHandsOf(libraryUser);

        //Then
        assertEquals(5, result.size());
        assertEquals("Secrets of Alamo", result.get(0).getTitle());
        assertEquals("Secretaries and Directors", result.get(1).getTitle());
        verify(libraryDatabaseMock, times(1)).listBooksInHandsOf(libraryUser);
    }
}