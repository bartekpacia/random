public class Parser {
    int[] digits;
    int index = 0;

    public static void main(String[] args) {
        new Parser(new int[]{1, 2, 3}).parse();
        new Parser(new int[]{1, 0, 1}).parse();
        new Parser(new int[]{1, 0, 2}).parse();
        new Parser(new int[]{3, 2, 4}).parse();
    }

    Parser(int[] digits) {
        this.digits = digits;
    }

    void parse() {
        boolean ok = parseS();
        if (!ok) {
            System.out.println("NIE, podana tablica nie tworzy słowa w danym języku");
        } else {
            System.out.println("TAK, podana tablica tworzy słowo w danym języku");
        }
    }

    boolean parseS() {
        if (index >= digits.length) {
            return true;
        }

        int nextDigit = digits[index];
        if (nextDigit == 1 || nextDigit == 2 || nextDigit == 3) {
            index++;
            return parseS();
        }

        if (nextDigit == 0) {
            index++;
            return parseB();
        }

        return false;
        // throw new RuntimeException("should never get here");
    }

    boolean parseB() {
        if (index >= digits.length) {
            return false;
        }

        int nextDigit = digits[index];

        if (nextDigit == 2 || nextDigit == 3) {
            index++;
            return parseB();
        }

        if (nextDigit == 1) {
            index++;
            return parseS();
        }

        return false;
    }
}