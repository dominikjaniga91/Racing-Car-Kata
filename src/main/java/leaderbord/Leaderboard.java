package leaderbord;

import java.util.*;

class Leaderboard {

    private final List<Race> races;

    public Leaderboard(Race... races) {
        this.races = Arrays.asList(races);
    }

    public Map<Driver, Integer> driverResults() {
        Map<Driver, Integer> results = new TreeMap<>();
        for (Race race : this.races) {
            for (Driver driver : race) {
                results.merge(driver, race.getPoints(driver), Integer::sum);
            }
        }
        return results;
    }

    public Set<Driver> driverRankings() {
        Map<Driver, Integer> results = driverResults();
        return new TreeSet<>(results.keySet());
    }
}