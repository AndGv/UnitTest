package com.company;

import java.util.Objects;

public class Book {

  private final int pages;
  private final String bookTitle;

  public Book(int pages, String bookTitle) {
    this.pages = pages;
    this.bookTitle = bookTitle;
  }

  public int getPages() {
    return pages;
  }

  public String getBookTitle() {
    return bookTitle;
  }

  @Override
  public String toString() {
    return "Book{" +
        "pages=" + pages +
        ", bookTitle='" + bookTitle + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Book book = (Book) o;
    return pages == book.pages && Objects.equals(bookTitle, book.bookTitle);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pages, bookTitle);
  }
}
