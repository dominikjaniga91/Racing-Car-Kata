package leaderbord;

import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaceTest {

    private final int points;
    private final Race race;
    private final Driver driver;

    public RaceTest(int points, Race race, Driver driver) {
        this.points = points;
        this.race = race;
        this.driver = driver;
    }

    @Test
    public void shouldCalculateDriverPoints() {
        assertEquals(points, race.getPoints(driver));
    }

}
