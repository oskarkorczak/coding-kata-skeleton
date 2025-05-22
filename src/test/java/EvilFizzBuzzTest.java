import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class EvilFizzBuzzTest {

    private final EvilFizzBuzz evilFizzBuzz = new EvilFizzBuzz();

    @Test
    void generatesCorrectSequence() {
        var seq = evilFizzBuzz.generate(15);

        assertThat(seq).isEqualTo("1, Wizz, FizzWizz, 4, BuzzWizz, Fizz, Wizz, 8, Fizz, Buzz, Wizz, Fizz, Wizz, 14, FizzBuzz");
    }

    @ParameterizedTest
    @MethodSource("divisibilityDetectionProvider")
    void divisibilityDetection(Integer value, Predicate<Integer> predicate, boolean expected) {
        assertThat(predicate.test(value)).isEqualTo(expected);
    }

    static Stream<Arguments> divisibilityDetectionProvider() {
        return Stream.of(
                Arguments.of(-9, EvilFizzBuzz.isDivisibleBy3, true),
                Arguments.of(-3, EvilFizzBuzz.isDivisibleBy3, true),
                Arguments.of(0, EvilFizzBuzz.isDivisibleBy3, true),
                Arguments.of(3, EvilFizzBuzz.isDivisibleBy3, true),
                Arguments.of(6, EvilFizzBuzz.isDivisibleBy3, true),
                Arguments.of(15, EvilFizzBuzz.isDivisibleBy3, true),

                Arguments.of(-8, EvilFizzBuzz.isDivisibleBy3, false),
                Arguments.of(-2, EvilFizzBuzz.isDivisibleBy3, false),
                Arguments.of(1, EvilFizzBuzz.isDivisibleBy3, false),
                Arguments.of(4, EvilFizzBuzz.isDivisibleBy3, false),
                Arguments.of(7, EvilFizzBuzz.isDivisibleBy3, false),
                Arguments.of(11, EvilFizzBuzz.isDivisibleBy3, false),

                Arguments.of(-15, EvilFizzBuzz.isDivisibleBy5, true),
                Arguments.of(-5, EvilFizzBuzz.isDivisibleBy5, true),
                Arguments.of(0, EvilFizzBuzz.isDivisibleBy5, true),
                Arguments.of(5, EvilFizzBuzz.isDivisibleBy5, true),
                Arguments.of(10, EvilFizzBuzz.isDivisibleBy5, true),
                Arguments.of(25, EvilFizzBuzz.isDivisibleBy5, true),

                Arguments.of(-14, EvilFizzBuzz.isDivisibleBy5, false),
                Arguments.of(-3, EvilFizzBuzz.isDivisibleBy5, false),
                Arguments.of(-1, EvilFizzBuzz.isDivisibleBy5, false),
                Arguments.of(3, EvilFizzBuzz.isDivisibleBy5, false),
                Arguments.of(8, EvilFizzBuzz.isDivisibleBy5, false),
                Arguments.of(16, EvilFizzBuzz.isDivisibleBy5, false),

                Arguments.of(-45, EvilFizzBuzz.isDivisibleBy15, true),
                Arguments.of(-15, EvilFizzBuzz.isDivisibleBy15, true),
                Arguments.of(0, EvilFizzBuzz.isDivisibleBy15, true),
                Arguments.of(15, EvilFizzBuzz.isDivisibleBy15, true),
                Arguments.of(15, EvilFizzBuzz.isDivisibleBy15, true),
                Arguments.of(60, EvilFizzBuzz.isDivisibleBy15, true),

                Arguments.of(-17, EvilFizzBuzz.isDivisibleBy15, false),
                Arguments.of(-9, EvilFizzBuzz.isDivisibleBy15, false),
                Arguments.of(-5, EvilFizzBuzz.isDivisibleBy15, false),
                Arguments.of(3, EvilFizzBuzz.isDivisibleBy15, false),
                Arguments.of(10, EvilFizzBuzz.isDivisibleBy15, false),
                Arguments.of(16, EvilFizzBuzz.isDivisibleBy15, false)
        );
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
}