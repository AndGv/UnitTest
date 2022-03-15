package com.company;

public class LettersCounter {


  public int countCharacters(char character, String text) {
    if (character == '\0' || text == null) {
      throw new IllegalArgumentException(String.format("Method input parameter character was = %s and text was %s", character, text));
    }


    int counter = 0;
    for (int i = 0; i < text.length(); i++) {
      if (text.charAt(i) == character) {
        counter++;
      }
    }
    return counter;

  }
}
