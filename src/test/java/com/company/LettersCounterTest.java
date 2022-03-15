package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LettersCounterTest {

  private LettersCounter lettersCounter = new LettersCounter();

  @Test
  public void Should_ThrowIllegalArgumentexception_When_TextIsNull() {
    char character = 'd';
    String text = null;
    String expected = String.format("Method input parameter character was = %s and text was %s", character, text);

    Throwable actual = assertThrows(IllegalArgumentException.class, () -> {
      lettersCounter.countCharacters(character, text);

    });

    assertEquals(expected, actual.getMessage());
  }

}
