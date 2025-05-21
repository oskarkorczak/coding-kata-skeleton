import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class EvilFizzBuzzTest {

    private final EvilFizzBuzz evilFizzBuzz = new EvilFizzBuzz();

    @Test
    void generatesCorrectInitialSequence() {
        var seq = evilFizzBuzz.generate(7);

        assertThat(seq).isEqualTo("1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11");
    }

    @ParameterizedTest
    @ValueSource(ints = { -6, -3, 0, 3, 6 })
    void shouldDetectIntegersDivisibleBy3(int value) {
        assertThat(EvilFizzBuzz.isDivisibleBy3Predicate.test(value)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = { -2, -1, 1, 4, 7 })
    void shouldNotDetectIntegersDivisibleBy3(int value) {
        assertThat(EvilFizzBuzz.isDivisibleBy3Predicate.test(value)).isFalse();
    }

    @Disabled("ATDD test should run when full implementation in place.")
    @Test
    void shouldGenerateCorrectInitialSequence() {
        var seq = evilFizzBuzz.generate(15);

        assertThat(seq).isEqualTo("1, Wizz, FizzWizz, 4, BuzzWizz, Fizz, Wizz, 8, Fizz, Buzz, Wizz, Fizz, Wizz, 14, FizzBuzz");
    }
}