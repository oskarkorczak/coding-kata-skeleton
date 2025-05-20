import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

public class EvilFizzBuzz {

    public String generate(int limit) {
        return IntStream
                .rangeClosed(1, limit)
                .boxed()
                .map( i -> {
                    if (i % 3 == 0) {
                        return "Fizz";
                    }
                    return String.valueOf(i);
                })
                .collect(joining(", "));
    }
}
