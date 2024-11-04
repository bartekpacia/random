import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class IdeaTest325387 {
    private static final SecureRandom SECURE_RANDOM = secureRandom();
    private static final List<String> ALGORITHMS = List.of("sha256", "sha384", "sha512", "sha224", "sha3-256", "sha3-384", "sha3-512", "sha3-224", "sha1", "md5");

    public static Stream<String> digests() {
        return toStreamWithRepeats(100000, ALGORITHMS);
    }

    @ParameterizedTest(name = "[{index}] {0}")
    @MethodSource("digests")
    public void testStringToDigestToString(final String algorithm) throws NoSuchAlgorithmException {
        final byte[] nextBytes = new byte[4096];
        final MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        IntStream.rangeClosed(1, 10).forEach(i -> {
            SECURE_RANDOM.nextBytes(nextBytes);
            messageDigest.update(nextBytes);
        });
        final byte[] digest = messageDigest.digest();
        assertThat(digest).isNotNull();
    }

    private static SecureRandom secureRandom() {
        try {
            return SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static <ELEMENT> Stream<ELEMENT> toStreamWithRepeats(final int repeats, final Collection<ELEMENT> collection) {
        return IntStream.rangeClosed(1, repeats).mapToObj(repeat -> collection.stream()).flatMap(d -> d).toList().stream();
    }
}