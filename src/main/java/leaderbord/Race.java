package leaderbord;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

class Race implements Iterable<Driver> {

    private final String name;
    private final List<Driver> results;
    private final Map<Driver, String> driverNames;

    public Race(String name, Driver... drivers) {
        this.name = name;
        this.results = Arrays.asList(drivers);
        this.driverNames = results.stream().collect(toMap(Function.identity(), Driver::toString));
    }

    public int getPoints(Driver driver) {
        int position = this.results.indexOf(driver);
        int points = Points.forPosition(position);
        driver.addPoints(points);
        return points;
    }

    @Override
    public Iterator<Driver> iterator() {
        return results.iterator();
    }

    @Override
    public String toString() {
        return name;
    }
}

