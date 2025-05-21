import java.util.function.Predicate;
import java.util.stream.IntStream;

import static java.lang.Math.floor;
import static java.lang.Math.sqrt;
import static java.util.stream.Collectors.joining;

public class EvilFizzBuzz {

    public String generate(int limit) {
        return IntStream
                .rangeClosed(1, limit)
                .boxed()
                .map(n -> switch (n) {
                    case Integer i when isDivisibleBy15.test(i) -> toLabel(i, "FizzBuzz");
                    case Integer i when isDivisibleBy3.test(i) -> toLabel(i, "Fizz");
                    case Integer i when isDivisibleBy5.test(i) -> toLabel(i, "Buzz");
                    case Integer i when isPrime.test(i) -> "Wizz";
                    default -> String.valueOf(n);
                })
                .collect(joining(", "));
    }

    static final Predicate<Integer> isDivisibleBy3 = i -> i % 3 == 0;
    static final Predicate<Integer> isDivisibleBy5 = i -> i % 5 == 0;
    static final Predicate<Integer> isDivisibleBy15 = i -> isDivisibleBy3.test(i) && isDivisibleBy5.test(i);
    static final Predicate<Integer> isPrime = value -> value > 1 && IntStream
            .rangeClosed(2, (int) floor(sqrt(value)))
            .noneMatch(divisor -> value % divisor == 0);

    private static String toLabel(int value, String label) {
        if (isPrime.test(value)) {
            return label + "Wizz";
        }
        return label;
    }
}
