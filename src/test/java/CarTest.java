import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void isCarRunning() {
        var car = new Car();

        assertThat(car.isRunning()).isFalse();
    }
}