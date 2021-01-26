package leaderbord;

import java.util.*;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

class Leaderboard {

    private final List<Race> races;

    public Leaderboard(Race... races) {
        this.races = Arrays.asList(races);
    }

    public Map<Driver, Integer> driverResults() {
        return races.stream().flatMap(Race::stream)
                .collect(toMap(identity(), Driver::getPoints));
    }

    public Set<Driver> driverRankings() {
        Map<Driver, Integer> results = driverResults();
        return new TreeSet<>(results.keySet());
    }
}