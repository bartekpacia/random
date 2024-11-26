import java.io.IOException;

public class BravoLib {
    public BravoLib() throws IOException {
        super();
    }

    // Return `num` incremented by 10.
    public int myLibraryFunc(int num) {
        int result = num;
        int firstIncrement = 5;
        result += firstIncrement;
        int secondIncrement = 5;
        result += secondIncrement;
        assert (firstIncrement + secondIncrement == 10);
        return result;
    }
}
