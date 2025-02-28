package com.example;

import org.jetbrains.annotations.ApiStatus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class Boo {
  @ApiStatus.OverrideOnly
  private void lol1() {}

  @ApiStatus.OverrideOnly
  final void lol2() {}

  @ApiStatus.OverrideOnly
  static void lol3() {}
}

public class Main {
  private static final int SOME_CONSTANT = 0;

  public static void main(String[] args) throws IOException {
    var a = new Foo("xd");
    var b = a.isValid();

    List<String> myList = new ArrayList<String>();
    myList.add("xd");
    myList.add("bruh");

    var myVar = myList.get(SOME_CONSTANT);
    var lolVar = myList.remove(SOME_CONSTANT);
    myList.add(SOME_CONSTANT, "lol");

    System.out.println("Hello and welcome! myVar is: " + myVar + lolVar);

  }
}
