package leaderbord;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

class Race implements Iterable<Driver> {

    private final String name;
    private final List<Driver> results;

    public Race(String name, Driver... drivers) {
        this.name = name;
        this.results = Arrays.asList(drivers);

    }

    int getPoints(Driver driver) {
        int position = this.results.indexOf(driver);
        int points = Points.forPosition(position);
        driver.addPoints(points);
        return points;
    }

    void run() {
        results.forEach(this::getPoints);
    }

    @Override
    public Iterator<Driver> iterator() {
        return results.iterator();
    }

    Stream<Driver> stream() {
        return results.stream();
    }

    @Override
    public String toString() {
        return name;
    }
}

