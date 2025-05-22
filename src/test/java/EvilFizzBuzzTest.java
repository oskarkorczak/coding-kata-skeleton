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
    void detectsDivisibilityByNumber(Integer number, Predicate<Integer> predicate, boolean expected) {
        assertThat(predicate.test(number)).isEqualTo(expected);
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
    @MethodSource("primeNumbersProvider")
    void detectsPrimeNumbers(Integer number, Predicate<Integer> predicate, boolean expected) {
        assertThat(predicate.test(number)).isEqualTo(expected);
    }

    static Stream<Arguments> primeNumbersProvider() {
        return Stream.of(
                Arguments.of(2, EvilFizzBuzz.isPrime, true),
                Arguments.of(3, EvilFizzBuzz.isPrime, true),
                Arguments.of(5, EvilFizzBuzz.isPrime, true),
                Arguments.of(7, EvilFizzBuzz.isPrime, true),
                Arguments.of(11, EvilFizzBuzz.isPrime, true),
                Arguments.of(13, EvilFizzBuzz.isPrime, true),
                Arguments.of(17, EvilFizzBuzz.isPrime, true),
                Arguments.of(23, EvilFizzBuzz.isPrime, true),
                Arguments.of(31, EvilFizzBuzz.isPrime, true),

                Arguments.of(-10, EvilFizzBuzz.isPrime, false),
                Arguments.of(-7, EvilFizzBuzz.isPrime, false),
                Arguments.of(-1, EvilFizzBuzz.isPrime, false),
                Arguments.of(0, EvilFizzBuzz.isPrime, false),
                Arguments.of(1, EvilFizzBuzz.isPrime, false),
                Arguments.of(4, EvilFizzBuzz.isPrime, false),
                Arguments.of(6, EvilFizzBuzz.isPrime, false),
                Arguments.of(14, EvilFizzBuzz.isPrime, false),
                Arguments.of(15, EvilFizzBuzz.isPrime, false),
                Arguments.of(16, EvilFizzBuzz.isPrime, false)
        );
    }
}