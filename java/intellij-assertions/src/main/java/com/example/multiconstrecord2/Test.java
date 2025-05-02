package com.example.multiconstrecord2;

// Test for IDEA-371419 and IDEA-371645
record Point2(double x, double y) {
  Point2(double first, double second) {
    this.x = first;
    this.y = second;
    System.out.println("created");
  }
}
