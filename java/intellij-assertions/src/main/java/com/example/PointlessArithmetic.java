package com.example;

import org.jetbrains.annotations.ApiStatus;

class PointlessArithmetic {
  static final int ZERO = 0;
  static final int ONE = 1;
  static final int TWO = 2;
  static final int TWO_TOO = 2;

  @ApiStatus.OverrideOnly
  final void test(int a) {
    int i = 0;
    int ii = a;
    int iii = TWO * a; // not pointless, even though we can infer it statically

    int j = a; // Even though TWO and TWO_TOO are equal, they may be quite different semantically. See IDEA-364437
  }
}
