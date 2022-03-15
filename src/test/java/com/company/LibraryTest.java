package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class LibraryTest {

  @Spy
  private List<Book> spyBooks = new ArrayList<>();

  @InjectMocks
  private Library library;

  @BeforeEach
  void beforeEach() {
    initBooks();
  }

  @Test
  public void Should_Get_All_Books() {
    assertEquals(spyBooks, library.getAllBooks());
  }

  @Test
  public void Should_Get_Number_Of_Books() {
    assertEquals(10, library.getAllBooks().size());
  }

  @Test
  public void Should_Find_Book_By_Title() {
    assertEquals(Optional.of(new Book(155, "Tamsybiu Bobas")), library.findBookByTitle("Tamsybiu Bobas"));
    assertEquals(Optional.empty(), library.findBookByTitle("Tamsybiu Bobas111"));
  }

  @Test
  public void Should_Book_With_Highest_Number_Of_Pages() {
    assertEquals(new Book(963, "Pingvino vakaras"), library.getBookWithHighestPageNumber());
  }

  private void initBooks() {
    library.getAllBooks().add(new Book(155, "Tamsybiu Bobas"));
    library.getAllBooks().add(new Book(200, "Parselis Kukis"));
    library.getAllBooks().add(new Book(62, "Cepelinu dienos"));
    library.getAllBooks().add(new Book(860, "Noriu valgyt"));
    library.getAllBooks().add(new Book(152, "Zuikio morkytes"));
    library.getAllBooks().add(new Book(963, "Pingvino vakaras"));
    library.getAllBooks().add(new Book(741, "Akmenu jura"));
    library.getAllBooks().add(new Book(123, "Dangaus spalvos"));
    library.getAllBooks().add(new Book(96, "Miegas"));
    library.getAllBooks().add(new Book(15, "Kukutis Mukutis"));
  }
}
