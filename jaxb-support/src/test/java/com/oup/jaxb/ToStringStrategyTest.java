package com.oup.jaxb;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ToStringStrategyTest {

  private ToStringStrategy subject;

  @Before
  public void setUp() throws Exception {
    subject = new ToStringStrategy();
  }

  @Test
  public void appendInternalShouldWrapStringsInQuotes() throws Exception {
    final String value = "field Value";

    assertEquals("'" + value + "'", subject.appendInternal(null, new StringBuilder(), value).toString());
  }

  @Test
  public void appendInternalShouldNotWrapNonStringsInQuotes() throws Exception {
    final boolean value = false;

    assertEquals(Boolean.toString(value), subject.appendInternal(null, new StringBuilder(), value).toString());
  }

  @Test
  public void appendArrayStartShouldAppendSquareBracket() {
    final StringBuilder actual = new StringBuilder();
    subject.appendArrayStart(actual);
    assertEquals("[", actual.toString());
  }

  @Test
  public void appendArrayEndShouldAppendSquareBracket() {
    final StringBuilder actual = new StringBuilder();
    subject.appendArrayEnd(actual);
    assertEquals("]", actual.toString());
  }
}
