package com.example;

class PointlessArithmetic {
  static final int ZERO = 0;
  static final int ONE = 1;
  static final int TWO = 2;
  static final int TWO_TOO = 2;

  void test(int a) {
    int i = ZERO * a;
    int ii = ONE * a;
    int iii = TWO * a; // not pointless, even though we can infer it statically

    int j = TWO - TWO_TOO + a; // Even though TWO and TWO_TOO are equal, they may be quite different semantically. See IDEA-364437
  }
}
