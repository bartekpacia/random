package com.example.multiconstrecord2;

/* Before
class Point3 {
  private final double x;
  private final double y;

  Point3(double x) {
    this.x = x;
    this.y = 0;
  }

  Point3(double x, double y) {
    this.x = x;
    this.y = y;
  }
}

*/

record Point2(double x, double y) {
  // Compact constructor for validation or custom logic
  Point2 {
    System.out.println("using 2-arg constructor");
  }

  // Custom constructor for one argument
  Point2(double x) {
    this(x, 0); // delegate to the canonical constructor
    System.out.println("using 1-arg constructor");
  }
}

/* Before
class Point3 {
  private final double x;
  private final double y;
  private final double z;

  Point3(double x) {
    this.x = x;
    this.y = 0;
    this.z = 0;
  }

  Point3(double x, double y) {
    this.x = x;
    this.y = y;
    this.z = 0;
  }

  Point3(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }
}
*/

record Point3(double x, double y, double z) {
  Point3(double x) {
    this(x, 0, 0); // delegate to another constructor
  }

  Point3(double x, double y) {
    this(x, y, 0); // delegate to another constructor
  }

  // This is a canonical constructor, and records have it provided automatically
  // Normal canonical constructor
  Point3(double x, double y, double z) {
    // this(x, y, z);
    System.out.println("Before assigning fields: ");
    this.x = x;
    this.y = y;
    this.z = z;
    System.out.println("After assigning fields");
  }

  // Compact canonical constructor
  // Point3 {
  //   System.out.println("Point is created!");
  // }
}
