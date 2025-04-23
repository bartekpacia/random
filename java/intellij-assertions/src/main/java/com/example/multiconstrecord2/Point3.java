package com.example.multiconstrecord2;

class Point2_broken {
  final double x;
  final double y;

  Point2_broken(double x, double y) {
    this.x = x;
    this.y = s;
  }
}

class Point2_class {
  private final double x;
  private final double y;

  Point2_class(double x) {
    this.x = x;
    this.y = 0;
  }

  Point2_class(double x, double y) {
    this.x = x;
    this.y = y;
  }
}

record Point2_record(double x, double y) {
  // Compact constructor for validation or custom logic
  Point2_record {
    System.out.println("using 2-arg constructor");
  }

  // Custom constructor for one argument
  Point2_record(double x) {
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
