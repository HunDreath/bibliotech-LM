package fr.amu.univ.miage.m1.glq.service;

import fr.amu.univ.miage.m1.glq.model.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookService {
    Map<String, Book> books = new HashMap<String, Book>();
    // Compteurs pour générer les IDs
    int bookIdCounter = 1;

    public BookService() {
    }

    public Map<String, Book> getBooks() {
        return books;
    }

    /**
     * Ajoute un livre à la bibliothèque.
     */
    public String addBook(
            String title, String author, String isbn, int year, int copies, String category) {
        String id = "B" + String.format("%05d", bookIdCounter++);
        Book book = new Book(id, title, author, isbn, year, copies, category);
        books.put(id, book);
        System.out.println("Livre ajouté : " + book);
        return id;
    }

    public Book getBook(String id) {
        return books.get(id);
    }

    public Book getBookByIsbn(String isbn) {
        for (Book book : books.values()) {
            if (book.getIsbn() != null && book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> getAllBooks() {
        return new ArrayList<Book>(books.values());
    }

    public List<Book> searchBooks(String query) {
        List<Book> results = new ArrayList<Book>();
        String q = query.toLowerCase();
        for (Book book : books.values()) {
            if ((book.getTitle() != null && book.getTitle().toLowerCase().contains(q))
                    || (book.getAuthor() != null && book.getAuthor().toLowerCase().contains(q))
                    || (book.getIsbn() != null && book.getIsbn().contains(q))) {
                results.add(book);
            }
        }
        return results;
    }

    public void updateBook(Book book) {
        if (books.containsKey(book.getId())) {
            books.put(book.getId(), book);
        }
    }

    public void deleteBook(String id) {
        books.remove(id);
    }
}