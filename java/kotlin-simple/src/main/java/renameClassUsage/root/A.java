// Copyright 2000-2025 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package root;

public class A {
    public Bruh() {
    }

    public final int x = 1;

    public static void sf() {

    }

    public void s() {
    }


    public String c() {
        System.out.println(x);
        sf();
        f();
        return null;
    }


    class Inner {
        void f() {
            System.out.println(A.this.x);
            System.out.println(A.sf());
            System.out.println(A.this.f());
        }
    }
}
