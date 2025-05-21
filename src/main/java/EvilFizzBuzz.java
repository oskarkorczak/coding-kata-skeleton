import java.util.function.Predicate;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class EvilFizzBuzz {

    static final Predicate<Integer> isDivisibleBy3Predicate = i -> i % 3 == 0;
    static final Predicate<Integer> isDivisibleBy5Predicate = i -> i % 5 == 0;
    static final Predicate<Integer> isDivisibleBy15Predicate = i -> isDivisibleBy3Predicate.test(i) && isDivisibleBy5Predicate.test(i);

    public String generate(int limit) {
        return IntStream
                .rangeClosed(1, limit)
                .boxed()
                .map( n -> switch (n) {
                    case Integer i when isDivisibleBy15Predicate.test(i) -> "FizzBuzz";
                    case Integer i when isDivisibleBy3Predicate.test(i) -> "Fizz";
                    case Integer i when isDivisibleBy5Predicate.test(i) -> "Buzz";
                    default -> String.valueOf(n);
                })
                .collect(joining(", "));
    }
}
