import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class EvilFizzBuzzTest {

    private final EvilFizzBuzz evilFizzBuzz = new EvilFizzBuzz();

    @Test
    void generatesCorrectSequence() {
        var seq = evilFizzBuzz.generate(15);

        assertThat(seq).isEqualTo("1, Wizz, FizzWizz, 4, BuzzWizz, Fizz, Wizz, 8, Fizz, Buzz, Wizz, Fizz, Wizz, 14, FizzBuzz");
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 23, 31})
    void detectsPrimeNumbers(int value) {
        assertThat(EvilFizzBuzz.isPrime.test(value)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {-7, -1, 0, 1, 4, 6, 8, 9, 10, 20, 55, 100})
    void doNotdetectPrimeNumbers(int value) {
        assertThat(EvilFizzBuzz.isPrime.test(value)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {-6, -3, 0, 3, 6})
    void shouldDetectIntegersDivisibleBy3(int value) {
        assertThat(EvilFizzBuzz.isDivisibleBy3.test(value)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {-2, -1, 1, 4, 7})
    void shouldNotDetectIntegersDivisibleBy3(int value) {
        assertThat(EvilFizzBuzz.isDivisibleBy3.test(value)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, -5, 0, 5, 10})
    void shouldDetectIntegersDivisibleBy5(int value) {
        assertThat(EvilFizzBuzz.isDivisibleBy5.test(value)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {-11, -7, 1, 3, 7})
    void shouldNotDetectIntegersDivisibleBy5(int value) {
        assertThat(EvilFizzBuzz.isDivisibleBy5.test(value)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {-30, -15, 0, 15, 30})
    void shouldDetectIntegersDivisibleBy15(int value) {
        assertThat(EvilFizzBuzz.isDivisibleBy15.test(value)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {-31, -27, 1, 13, 17, 31})
    void shouldNotDetectIntegersDivisibleBy15(int value) {
        assertThat(EvilFizzBuzz.isDivisibleBy15.test(value)).isFalse();
    }
}