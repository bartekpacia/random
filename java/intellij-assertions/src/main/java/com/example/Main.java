package com.example;

import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    Main main = new Main();
    main.funAlpha();
  }

  private void funAlpha() {
    funBravo();
  }

  private void funBravo() {
    funCharlie();
  }

  private void funCharlie() {
    try {
      foo();
    } catch (NullPointerException ex) {
      throw new IllegalArgumentException("NoooOoo! Null was passed", ex);
    }
  }

  private void foo() {
    bar();
  }

  private void bar() {
    Main m = null;
    m.bar();
  }
}



