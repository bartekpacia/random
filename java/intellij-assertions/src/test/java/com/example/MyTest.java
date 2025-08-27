package com.example;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class MyTest {
  public static class MyNestedTest {

    @Test
    public void test() {
      Assert.assertEquals(10, 5 + 5);
    }
  }
}
