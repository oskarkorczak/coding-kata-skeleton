import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EvilFizzBuzzTest {

    private final EvilFizzBuzz evilFizzBuzz = new EvilFizzBuzz();

    @Test
    void shouldDetectIntegersDivisibleBy3() {
        var seq = evilFizzBuzz.generate(7);

        assertThat(seq).isEqualTo("1, 2, Fizz, 4, 5, Fizz, 7");
    }

    @Disabled("ATDD test should run when full implementation in place.")
    @Test
    void shouldGenerateCorrectInitialSequence() {
        var seq = evilFizzBuzz.generate(15);

        assertThat(seq).isEqualTo("1, Wizz, FizzWizz, 4, BuzzWizz, Fizz, Wizz, 8, Fizz, Buzz, Wizz, Fizz, Wizz, 14, FizzBuzz");
    }
}