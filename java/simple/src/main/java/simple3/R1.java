package simple3;

public class Main {
    public static void main(String[] args) {
        R1 r1 = new R1("Hello    ", "if spaces then we broken");
        System.out.println(r1.part1() + r1.part2());
    }
}

// class R1 {
//     final String part1;
//     final String part2;
// 
//     R1(CharSequence part1, String part2) {
//         this.part1 = part1.toString().trim();
//         this.part2 = part2;
//     }
// }

record R1(String part1, String part2) {
	R1(CharSequence part1, String part2) {
	  this(part1.toString().trim(), part2);
	}
}
