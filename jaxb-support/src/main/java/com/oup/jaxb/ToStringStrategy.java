package com.oup.jaxb;

import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;

/**
 * Custom toString style for JAXB generated classes. Will produce a style like
 * BrandProfile{brand='AM', tier='tier', channel=WEB}.
 */
public class ToStringStrategy extends JAXBToStringStrategy {

  @Override
  protected void appendNullText(final StringBuilder buffer) {
    buffer.append("NULL");
  }

  @Override
  protected void appendContentStart(final StringBuilder buffer) {
    buffer.append("{");
  }

  @Override
  protected void appendContentEnd(final StringBuilder buffer) {
    buffer.append("}");
  }

  @Override
  protected void appendArrayStart(final StringBuilder buffer) {
    buffer.append("[");
  }

  @Override
  protected void appendArrayEnd(final StringBuilder buffer) {
    buffer.append("]");
  }

  @Override
  protected void appendIdentityHashCode(final StringBuilder buffer, final Object object) {
    // Don't append identity hash
  }

  @Override
  protected StringBuilder appendInternal(final ObjectLocator locator, final StringBuilder buffer, final Object value) {
    if (value instanceof String) {
      buffer.append("'").append(value.toString()).append("'");
    } else {
      super.appendInternal(locator, buffer, value);
    }
    return buffer;
  }
}
