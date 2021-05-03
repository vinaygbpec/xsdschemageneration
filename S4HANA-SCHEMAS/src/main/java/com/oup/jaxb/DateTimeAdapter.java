package com.oup.jaxb;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.ReadablePartial;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Adapter used to marshal the various different date formats in the amadeus Connector xsd files.
 */
public final class DateTimeAdapter {

  private DateTimeAdapter() {
    // No construction allowed
  }

  private static final DateTimeFormatter NO_TIME = DateTimeFormat.forPattern("ddMMyy");
  private static final DateTimeFormatter TIME = DateTimeFormat.forPattern("HHmm");

  public static String marshalDateToLocalDate(final LocalDate v) {
    return print(NO_TIME, v);
  }

  public static LocalDate unmarshalLocalDateToDate(final String v) {
    if (v == null) {
      return null;
    }
    return NO_TIME.parseDateTime(v).toLocalDate();
  }

  public static String marshalTimeToLocalTime(final LocalTime v) {
    return print(TIME, v);
  }

  public static LocalTime unmarshalLocalTimeToTime(final String v) {
    if (v == null) {
      return null;
    }
    return TIME.parseDateTime(v).toLocalTime();
  }

  private static String print(final DateTimeFormatter formatter, final ReadablePartial o) {
    if (o == null) {
      return null;
    }

    return formatter.print(o);
  }

}
