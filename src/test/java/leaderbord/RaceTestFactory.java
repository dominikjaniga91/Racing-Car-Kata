package leaderbord;

import org.testng.annotations.Factory;

public class RaceTestFactory {

    private final Driver driver1 = new Driver("Nico Rosberg", "DE");
    private final Driver driver2 = new Driver("Lewis Hamilton", "UK");
    private final Driver driver3 = new Driver("Sebastian Vettel", "DE");

    @Factory
    public Object[] raceFactory() {
        return new Object[]{
                new RaceTest(25, new Race("Race", driver1, driver2, driver3), driver1),
                new RaceTest(25, new Race("Race", driver2, driver1, driver3), driver2),
                new RaceTest(25, new Race("Race", driver3, driver2, driver1), driver3),
                new RaceTest(18, new Race("Race", driver3, driver2, driver1), driver2),
                new RaceTest(15, new Race("Race", driver3, driver2, driver1), driver1),
                new RaceTest(18, new Race("Race", driver2, driver3, driver1), driver3),
        };
    }
}
