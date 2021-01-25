package leaderbord;

import java.util.*;

class Leaderboard {

    private final List<Race> races;

    public Leaderboard(Race... races) {
        this.races = Arrays.asList(races);
    }

    public Map<String, Integer> driverResults() {
        Map<String, Integer> results = new TreeMap<>();
        for (Race race : this.races) {
            for (Driver driver : race) {
                results.merge(driver.toString(), race.getPoints(driver), Integer::sum);
            }
        }
        return results;
    }

    public Set<String> driverRankings() {
        Map<String, Integer> results = driverResults();
        return new TreeSet<>(results.keySet());
    }
}