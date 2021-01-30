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

    public Set<Driver> driverRankings() {
        return races.stream()
                .peek(Race::run)
                .flatMap(Race::stream)
                .sorted(comparing(Driver::getPoints, reverseOrder())
                        .thenComparing(Driver::getName))
                .collect(toCollection(LinkedHashSet::new));
    }
}