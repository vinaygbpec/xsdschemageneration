package com.oup.jaxb;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePartial;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

/**
 * Adapter used to handle standard date/time patterns.
 */
public final class JodaDateTimeAdapter {

  private JodaDateTimeAdapter() {
    // No construction allowed
  }

  /**
   * Turn a string in the format <code>yyyy-MM-ddTHH:mm:ss.SSSZ</code> into a {@link DateTime}.
   * @param v Input date and time string
   * @return Parsed date and time.
   */
  public static DateTime unmarshalDateTimeWithTimezone(final String v) {
    if (v == null) {
      return null;
    }
    return ISODateTimeFormat.dateTimeParser().withOffsetParsed().parseDateTime(v);
  }

  /**
   * Turn a {@link DateTime} into a string in the format <code>yyyy-MM-ddTHH:mm:ss.SSSZ</code>.
   * @param v Input date and time.
   * @return Formatted date and time string.
   */
  public static String marshalDateTimeWithTimezone(final DateTime v) {
    return print(v, ISODateTimeFormat.dateTime());
  }

  /**
   * Turn a string in the format <code>yyyy-MM-dd</code> into a {@link LocalDate}.
   * @param v Input date string
   * @return Parsed date
   */
  public static LocalDate unmarshalDateWithoutTimezone(final String v) {
    if (v == null) {
      return null;
    }
    // TODO Change to parseLocalDate once Darwin no longer uses Joda Time 1.6
    return ISODateTimeFormat.dateParser().parseDateTime(v).toLocalDate();
  }

  /**
   * Turn a {@link LocalDate} into a string in the format <code>yyyy-MM-dd</code>.
   * @param v Input date
   * @return Formatted date as a string
   */
  public static String marshalDateWithoutTimezone(final LocalDate v) {
    return print(v, ISODateTimeFormat.date());
  }

  /**
   * Turn a string in the format <code>HH:mm:ss.SSS</code> into a {@link LocalTime}.
   * @param v Input time string
   * @return Parsed time
   */
  public static LocalTime unmarshalTime(final String v) {
    if (v == null) {
      return null;
    }
    // TODO Change to parseLocalTime once Darwin no longer uses Joda Time 1.6
    return ISODateTimeFormat.timeParser().parseDateTime(v).toLocalTime();
  }

  /**
   * Turn a {@link LocalTime} into a string in the format <code>HH:mm:ss.SSS</code>.
   * @param v Input time
   * @return Formatted time as a string
   */
  public static String marshalTime(final LocalTime v) {
    return print(v, ISODateTimeFormat.time());
  }

  /**
   * Turn a string in the format <code>yyyy-MM-ddTHH:mm:ss.SSS</code> into a {@link LocalDateTime}.
   * @param v Input date and time string
   * @return Parsed date and time
   */
  public static LocalDateTime unmarshalDateTimeWithoutTimezone(final String v) {
    if (v == null) {
      return null;
    }
    // TODO Change to parseLocalDateTime once Darwin no longer uses Joda Time 1.6
    return ISODateTimeFormat.dateTimeParser().parseDateTime(v).toLocalDateTime();
  }

  /**
   * Turn a {@link LocalDateTime} into a string in the format <code>yyyy-MM-ddTHH:mm:ss.SSS</code>.
   * @param v Input date and time
   * @return Formatted date and time as a string
   */
  public static String marshalDateTimeWithoutTimezone(final LocalDateTime v) {
    return print(v, ISODateTimeFormat.dateTime());
  }

  private static String print(final ReadableInstant o, final DateTimeFormatter f) {
    if (o == null) {
      return null;
    }

    return f.print(o);
  }

  private static String print(final ReadablePartial o, final DateTimeFormatter f) {
    if (o == null) {
      return null;
    }

    return f.print(o);
  }

}
