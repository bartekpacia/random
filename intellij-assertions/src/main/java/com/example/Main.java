package com.example;

import pacia.tech.ExampleLib;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello and welcome!");
    ExampleLib l = new ExampleLib();
    int myvar = l.myLibraryFunc(10);
    System.out.println("myvar = " + myvar);
  }
}
