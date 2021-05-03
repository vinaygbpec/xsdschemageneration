package com.oup.jaxb;

import org.hamcrest.CustomTypeSafeMatcher;
import org.hamcrest.Matcher;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Instant;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class JodaDateTimeAdapterTest {

  private static final class StringOfLength extends CustomTypeSafeMatcher<String> {
    private final int length;

    public StringOfLength(int length) {
      super("string of length " + length);
      this.length = length;
    }

    @Override
    protected boolean matchesSafely(String item) {
      return item.length() == length;
    }
  }

  private static Matcher<String> stringOfLength(int length) {
    return new StringOfLength(length);
  }

  @Test
  public void unmarshalDateTimeWithTimezoneShouldExpectTimezone() {
    final DateTime actual = JodaDateTimeAdapter.unmarshalDateTimeWithTimezone("2012-11-10T12:01:30.000+02");

    assertEquals(2012, actual.getYearOfEra());
    assertEquals(11, actual.getMonthOfYear());
    assertEquals(10, actual.getDayOfMonth());
    assertEquals(12, actual.getHourOfDay());
    assertEquals(1, actual.getMinuteOfHour());
    assertEquals(30, actual.getSecondOfMinute());
    assertEquals(0, actual.getMillisOfSecond());
    assertEquals(TimeUnit.HOURS.toMillis(2), actual.getZone().getOffset(Instant.now()));
  }

  @Test
  public void unmarshalDateTimeWithTimezoneShouldHandleNull() {
    final DateTime actual = JodaDateTimeAdapter.unmarshalDateTimeWithTimezone(null);

    assertNull(actual);
  }

  @Test
  public void marshalDateTimeWithTimezoneShouldHandleNull() {
    final String actual = JodaDateTimeAdapter.marshalDateTimeWithTimezone(null);

    assertNull(actual);
  }

  @Test
  public void marshalDateTimeWithTimezoneShouldIncludeTimezone() {
    final int year = 2012;
    final int month = 11;
    final int day = 10;
    final int hour = 12;
    final int minute = 1;
    final int second = 30;
    final int millisecond = 0;
    final int timezone = 2;
    final String actual = JodaDateTimeAdapter.marshalDateTimeWithTimezone(
        new DateTime(year, month, day, hour, minute, second, millisecond, DateTimeZone.forOffsetHours(timezone)));

    // "2012-11-10T12:01:30.000+02"
    final String expected = String.format("%1$02d-%2$02d-%3$02dT%4$02d:%5$02d:%6$02d.%7$03d+%8$02d:00", year, month,
        day, hour, minute, second, millisecond, timezone);
    assertEquals(expected, actual);
  }

  @Test
  public void marshalDateShouldNotIncludeTimezone() {
    final String actual = JodaDateTimeAdapter.marshalDateWithoutTimezone(new LocalDate());

    assertThat(actual, stringOfLength(10));
  }

  @Test
  public void unmarshalDateShouldNotExpectTimezone() {
    final LocalDate actual = JodaDateTimeAdapter.unmarshalDateWithoutTimezone("2012-11-10");

    assertEquals(2012, actual.getYearOfEra());
    assertEquals(11, actual.getMonthOfYear());
    assertEquals(10, actual.getDayOfMonth());
  }

  @Test
  public void unmarshalDateShouldHandleNull() {
    final LocalDate actual = JodaDateTimeAdapter.unmarshalDateWithoutTimezone(null);

    assertNull(actual);
  }

  @Test
  public void unmarshalLocalDateTimeShouldNotExpectTimezone() {
    final LocalDateTime actual = JodaDateTimeAdapter.unmarshalDateTimeWithoutTimezone("2012-08-10T12:01:30.000");

    assertEquals(2012, actual.getYearOfEra());
    assertEquals(8, actual.getMonthOfYear());
    assertEquals(10, actual.getDayOfMonth());
    assertEquals(12, actual.getHourOfDay());
    assertEquals(1, actual.getMinuteOfHour());
    assertEquals(30, actual.getSecondOfMinute());
    assertEquals(0, actual.getMillisOfSecond());
  }

  @Test
  public void unmarshalLocalDateTimeShouldHandleNull() {
    final LocalDateTime actual = JodaDateTimeAdapter.unmarshalDateTimeWithoutTimezone(null);

    assertNull(actual);
  }

  @Test
  public void marshalTimeShouldNotIncludeTimezone() {
    final String actual = JodaDateTimeAdapter.marshalTime(new LocalTime());

    assertThat(actual, stringOfLength(12));
  }

  @Test
  public void marshalTimeShouldHandleNull() {
    final String actual = JodaDateTimeAdapter.marshalTime(null);

    assertNull(actual);
  }

  @Test
  public void unmarshalTimeShouldNotExpectTimezone() {
    final LocalTime actual = JodaDateTimeAdapter.unmarshalTime("12:01:30.000");

    assertEquals(12, actual.getHourOfDay());
    assertEquals(1, actual.getMinuteOfHour());
    assertEquals(30, actual.getSecondOfMinute());
    assertEquals(0, actual.getMillisOfSecond());
  }

  @Test
  public void unmarshalTimeShouldHandleNull() {
    final LocalTime actual = JodaDateTimeAdapter.unmarshalTime(null);

    assertNull(actual);
  }

}
