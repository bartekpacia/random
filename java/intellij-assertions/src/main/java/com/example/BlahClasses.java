package com.example;

public class BlahClasses {
  private int instanceInt = 1;
  private static int staticInt = 1;

  public class Foo {
    void foo() {
      var a = instanceInt;
    }
  }

  private Listener listener = new Listener() {
    @Override
    public void onClick() {

    }
  };

  public void main(int parameter) {
    int localVar = 2;

    class PossiblyStaticLocalClass {
      private final String name;

      PossiblyStaticLocalClass(String name) {
        this.name = name;
      }

      public String getName() {
        return name;
      }

      public int nested() {
        return staticInt;
      }

      public int nested2(int myParameter) {
        return staticInt + myParameter; // + localVar
      }
    }

    class ImpossiblyStaticLocalClass_1 {
      private final String name;

      ImpossiblyStaticLocalClass_1(String name) {
        this.name = name;
      }

      public String getName() {
        return name;
      }

      public int nested() {
        return instanceInt;
      }
    }

    class ImpossiblyStaticLocalClass_2 {
      private final String name;

      ImpossiblyStaticLocalClass_2(String name) {
        this.name = name;
      }

      public String getName() {
        return name;
      }

      public int nested() {
        return localVar;
      }
    }

    class ImpossiblyStaticLocalClass_3 {
      private final String name;

      ImpossiblyStaticLocalClass_3(String name) {
        this.name = name;
      }

      public String getName() {
        return name;
      }

      public int nested() {
        return parameter;
      }
    }

    record Record(String name) {
      int foo() {
        // return a;
        return staticInt;
      }
    }
  }
}

interface Listener {
  void onClick();
}


class Bar {
  void test() {
    int localVar = 2;

    class Point {
      private final double x;
      private final double y;

      Point(double x, double y) {
        this.x = x;
        this.y = y;
      }

      public double getX() {
        return x;
      }

      public double getY() {
        return y;
      }

      Point shiftX() {
        double a = x;
        return new Point(x + 1, y);
      }
    }
  }
}
