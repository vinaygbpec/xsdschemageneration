package com.oup.jaxb;

import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class UUIDAdapterTest {

  @Test
  public void unmarshalUUIDWithBrackets() throws Exception {
    final String id = "999ae4a3-5d08-44d0-950c-0f88001cf20e";
    assertEquals(UUID.fromString(id), UUIDAdapter.unmarshalUUID("{" + id + "}"));
  }

  @Test
  public void unmarshalNullUUID() throws Exception {
    assertNull(UUIDAdapter.unmarshalUUID(null));
  }

  @Test
  public void unmarshalUUIDWithoutBrackets() throws Exception {
    final String id = "999ae4a3-5d08-44d0-950c-0f88001cf20e";
    assertEquals(UUID.fromString(id), UUIDAdapter.unmarshalUUID(id));
  }

  @Test
  public void marshalNullUUID() {
    assertNull(UUIDAdapter.marshalUUID(null));
  }

  @Test
  public void marshalUUID() {
    final String id = "02071209-1206-0062-7728-000000795470";
    assertEquals(id, UUIDAdapter.marshalUUID(UUID.fromString(id)));
  }
}
