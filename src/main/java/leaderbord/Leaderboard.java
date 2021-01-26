package leaderbord;

import java.util.*;

import static java.util.stream.Collectors.toCollection;

class Leaderboard {

    private final List<Race> races;

    public Leaderboard(Race... races) {
        this.races = Arrays.asList(races);
    }

    public Map<Driver, Integer> driverResults() {

        Map<Driver, Integer> results = new HashMap<>();
        for (Race race : this.races) {
            for (Driver driver : race) {
                results.merge(driver, race.getPoints(driver), Integer::sum);
            }
        }
        return results;
    }

    public Set<Driver> driverRankings() {
        return races.stream().flatMap(Race::stream)
                .collect(toCollection(TreeSet::new));
    }
}