import java.util.function.Predicate;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class EvilFizzBuzz {

    static final Predicate<Integer> isDivisibleBy3Predicate = i -> i % 3 == 0;
    static final Predicate<Integer> isDivisibleBy5Predicate = i -> i % 5 == 0;
    static final Predicate<Integer> isDivisibleBy15Predicate = i -> isDivisibleBy3Predicate.test(i) && isDivisibleBy5Predicate.test(i);
    static final Predicate<Integer> isPrime = value -> {
        return value > 1 && IntStream
                .rangeClosed(2, (int) Math.floor(Math.sqrt(value)))
                .noneMatch(divisor -> value % divisor == 0);
    };

    public String generate(int limit) {
        return IntStream
                .rangeClosed(1, limit)
                .boxed()
                .map( n -> switch (n) {
                    case Integer i when isDivisibleBy15Predicate.test(i) -> {
                        if (isPrime.test(i)) {
                            yield "FizzBuzzWizz";
                        }
                        yield "FizzBuzz";
                    }
                    case Integer i when isDivisibleBy3Predicate.test(i) -> {
                        if (isPrime.test(i)) {
                            yield "FizzWizz";
                        }
                        yield "Fizz";
                    }
                    case Integer i when isDivisibleBy5Predicate.test(i) -> {
                        if (isPrime.test(i)) {
                            yield "BuzzWizz";
                        }
                        yield "Buzz";
                    }
                    case Integer i when isPrime.test(i) -> "Wizz";
                    default -> String.valueOf(n);
                })
                .collect(joining(", "));
    }
}
