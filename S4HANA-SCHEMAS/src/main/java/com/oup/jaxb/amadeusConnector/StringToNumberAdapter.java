package com.oup.jaxb.amadeusConnector;

import javax.xml.bind.DatatypeConverter;

public final class StringToNumberAdapter {

  private StringToNumberAdapter() {
    // No construction allowed
  }

  public static String marshalIntToString(final int v) {
    return DatatypeConverter.printInt(v);
  }

  public static int unmarshalIntToString(final String v) {
    if (v == null) {
      return 0;
    }
    return DatatypeConverter.parseInt(v.trim());
  }
}
