package com.example;

import java.util.List;
import java.util.function.Consumer;

public class SimplifyFalse {
  private void notifyListeners(List<Consumer<Integer>> listeners) {
    if (isClosed() || listeners.isEmpty()) {
      return;
    }
    System.out.println("123");
  }

  private boolean isClosed() {
    return false;
  }
}
