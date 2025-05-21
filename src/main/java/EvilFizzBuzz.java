import java.util.function.Predicate;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class EvilFizzBuzz {

    static final Predicate<Integer> isDivisibleBy3Predicate = i -> i % 3 == 0;
    static final Predicate<Integer> isDivisibleBy5Predicate = i -> i % 5 == 0;

    public String generate(int limit) {
        return IntStream
                .rangeClosed(1, limit)
                .boxed()
                .map( i -> {
                    if (isDivisibleBy3Predicate.test(i)) {
                        return "Fizz";
                    }
                    if (isDivisibleBy5Predicate.test(i)) {
                        return "Buzz";
                    }
                    return String.valueOf(i);
                })
                .collect(joining(", "));
    }
}
