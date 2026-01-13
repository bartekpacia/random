// Copyright 2000-2025 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package root;

public class A {
    public A() {
    }

    public final int x = 1;

    public void f() {

    }

    public static void s() {
    }


    public String c() {
        System.out.println(x);
        f();
        f();
        return null;
    }


    class Inner {
        void f() {
            System.out.println(A.this.x);
            System.out.println(A.s());
            System.out.println(A.this.f());
        }
    }
}
