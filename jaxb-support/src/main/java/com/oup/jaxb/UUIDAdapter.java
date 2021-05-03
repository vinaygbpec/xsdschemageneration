package com.oup.jaxb;

import java.util.UUID;

/**
 * Adapter used to handle {@link UUID}s which are expected to be of the XSD type 'string'.
 */
public final class UUIDAdapter {

  private UUIDAdapter() {
    // No construction allowed
  }

  /**
   * Turn a string in the format {@link UUID#toString() as described} into a {@link UUID}. The string may optionally be
   * wrapped in <code>{}</code>.
   * @param v Input string.
   * @return UUID.
   */
  public static UUID unmarshalUUID(final String v) {
    if (v == null) {
      return null;
    }
    if (v.startsWith("{")) {
      return UUID.fromString(v.substring(1, v.length() - 1));
    }
    return UUID.fromString(v);
  }

  /**
   * Turn a {@link UUID} into a string with the format {@link UUID#toString() described}.
   * @param v UUID to format.
   * @return Formatted UUID as a string.
   */
  public static String marshalUUID(final UUID v) {
    if (v == null) {
      return null;
    }
    return v.toString();
  }
}
