package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.prototype.Prototype;


import java.util.HashSet;
import java.util.Set;

public class Library extends Prototype<Library> {
    private String name;
    Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }


    public Library shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = super.clone();
        clonedLibrary.books = new HashSet<>();
        for (Book book : books) {
            clonedLibrary.books.add(new Book(book.getTitle(), book.getAuthor(), book.getPublicationDate()));
        }

        return clonedLibrary;
    }

}
