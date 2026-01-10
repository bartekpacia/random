// Copyright 2000-2025 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package other;

import root.A;


class B {
    void f() {
        A a = new A();
        a.f();
        System.out.println(a.x);
    }
}
