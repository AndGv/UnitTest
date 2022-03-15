package com.company;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ListMockTest {

  @Test
  public void whenNotUsingMockAnnotation() {
    List<String> mockedList = mock(ArrayList.class);
    mockedList.add("one");
    Mockito.verify(mockedList, times(1)).add("one");
    assertEquals(0, mockedList.size());

    when(mockedList.size()).thenReturn(100).thenReturn(45);
    assertEquals(100, mockedList.size());
    assertEquals(45, mockedList.size());

  }

  @Mock
  private List<String> mockedList;

  @Test
  public void whenUsingMockAnnotation() {
    List<String> mockedList = mock(ArrayList.class);
    mockedList.add("one");
    Mockito.verify(mockedList, times(1)).add("one");
    assertEquals(0, mockedList.size());

    when(mockedList.size()).thenReturn(100).thenReturn(45);
    assertEquals(100, mockedList.size());
    assertEquals(45, mockedList.size());
  }

  @Test
  public void WhenNotUsingArgumentCaptorAnnotation() {
    List<String> mockedList = mock(ArrayList.class);
    ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

    mockedList.add("one");
    verify(mockedList).add(argumentCaptor.capture());

    assertEquals("one", argumentCaptor.getValue());
  }

  @Mock
  List<String> MockedListAnnotation;
  @Captor
  ArgumentCaptor<String> argumentCaptor;

  @Test
  public void WhenUsingArgumentCaptorAnnotation() {

    mockedList.add("one");
    mockedList.add("two");

    verify(mockedList, times(2)).add(argumentCaptor.capture());

    assertEquals("one", argumentCaptor.getAllValues().get(0));
    assertEquals("two", argumentCaptor.getAllValues().get(1));

  }

  @Mock
  private Map<String,String> wordMap;

  @InjectMocks
  private MyDictionary dictionary;

  @Test
  public void injectMocks(){
    when (wordMap.get("aWord")).thenReturn("aMeaning");  // iskviecia konkretu nurodyta argumenta
    assertEquals("aMeaning",dictionary.getMeaning(("aWord")));

    when(wordMap.get(any(String.class))).thenReturn ("anything");   // visada gausim anything.tas get any iskviecia bet ka
    assertEquals("any", dictionary.getMeaning(""));
  }
}
