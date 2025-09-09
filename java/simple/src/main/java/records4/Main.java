package records4;

public class Main {
    public static void main(String[] args) {
        new Test("XD");
    }
}


class Test {
    private final int[] xyz;

    Test(String...data){
        this.xyz = new int[10];
    }

    public int[] xyz () {
        return xyz;
    }
}
