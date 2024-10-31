package com.example;

import pacia.tech.BravoLib;
import pacia.tech.ExampleLib;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    System.out.println("Hello and welcome!");
    ExampleLib l = new ExampleLib();
    int myvar = l.myLibraryFunc(10);

    BravoLib b = new BravoLib();

    System.out.println("myvar = " + myvar);
  }
}
