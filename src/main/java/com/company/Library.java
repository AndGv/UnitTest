package com.company;

import java.util.List;
import java.util.Optional;

public class Library {

  private final List<Book> bookList;

  public Library(List<Book> bookList) {
    this.bookList = bookList;
  }

  public List<Book> getAllBooks() {
    return bookList;
  }

  public int getNumberOfBooks() {
    return bookList.size();
  }

  public Optional<Book> findBookByTitle(String bookTitle) {
    // return bookList.stream().filter(book -> book.getBookTitle().equals(bookTitle)).findFirst();
    for (Book book : bookList) {
      if (book.getBookTitle().equals(bookTitle)) {
        return Optional.of(book);
      }
    }
    return Optional.empty();
  }

  public Book getBookWithHighestPageNumber() {
   // return bookList.stream().max(Comparator.comparingInt(Book::getPages)).orElse(null);
    Book bookWithHighestPageNumber = bookList.get(0);
    for (Book book : bookList) {
      if (book.getPages() > bookWithHighestPageNumber.getPages()) {
        bookWithHighestPageNumber = book;
      }
    }
    return bookWithHighestPageNumber;
  }

}


