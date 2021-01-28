package leaderbord;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;
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
                .sorted(comparing(Driver::getPoints, reverseOrder())
                        .thenComparing(Driver::getName))
                .collect(toCollection(LinkedHashSet::new));
    }
}