package leaderbord;

import java.util.*;

class Race implements Iterable<Driver> {

    private final String name;
    private final List<Driver> results;
    private final Map<Driver, String> driverNames;

    public Race(String name, Driver... drivers) {
        this.name = name;
        this.results = Arrays.asList(drivers);
        this.driverNames = new HashMap<>();
        for (Driver driver : results) {
            String driverName = driver.toString();
            if (driver instanceof SelfDrivingCar) {
                driverName = "Self Driving Car - " + driver.getCountry() + " (" + ((SelfDrivingCar) driver).getAlgorithmVersion() + ")";
            }
            this.driverNames.put(driver, driverName);
        }
    }

    public int getPoints(Driver driver) {
        int position = this.results.indexOf(driver);
        return Points.forPosition(position);
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

