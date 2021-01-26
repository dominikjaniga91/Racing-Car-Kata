package leaderbord;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.Map;
import java.util.Set;

import static leaderbord.TestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeaderboardTest {


    @Test
    public void shouldReturnTheSameRanking_afterPerformTheRace() {
        //given
        Set<Driver> racers = Set.of(TestData.driver1, driver2, driver3);
        Race race = new Race("Night race", TestData.driver1, driver2, driver3);
        Leaderboard leaderboard = new Leaderboard(race);

        //when
        Map<Driver, Integer> stringIntegerMap = leaderboard.driverResults();
        Set<Driver> rankings = leaderboard.driverRankings();

        //then
        Assert.assertEquals(rankings, racers);
    }


    @Test
    public void shouldReturnTheWinner_afterDriverWontTheRace() {
        //given
        Driver winner = driver1;
        Race race = new Race("Night race", driver1, driver2, driver3);
        Leaderboard leaderboard = new Leaderboard(race);

        //when
        leaderboard.driverResults();
        Set<Driver> rankings = leaderboard.driverRankings();
        System.out.println(rankings);

        //then
        Assert.assertEquals(driver1, rankings.iterator().next());
    }


    @Test
    public void itShouldSumThePoints() {
        // setup
        Driver winner = new Driver("Lewis Hamilton", "UK");
        // act
        Map<Driver, Integer> results = TestData.sampleLeaderboard1.driverResults();

        // verify
        assertTrue(results.containsKey(winner), "results " + results);
        assertEquals(18 + 18 + 25, (int) results.get(winner));
    }

    @Test
    public void isShouldFindTheWinner() {
        // setup
        Driver winner = new Driver("Lewis Hamilton", "UK");

        // act
        Set<Driver> result = TestData.sampleLeaderboard1.driverRankings();

        // verify
        assertEquals(winner, result.iterator().next());
    }

    @Test
    public void itShouldKeepAllDriversWhenSamePoints() {
        // setup
        // bug, drops drivers with same points
        Race winDriver1 = new Race("Australian Grand Prix", driver1, driver2, driver3);
        Race winDriver2 = new Race("Malaysian Grand Prix", driver2, driver1, driver3);
        Leaderboard exEquoLeaderBoard = new Leaderboard(winDriver1, winDriver2);

        // act
        Set<Driver> rankings = exEquoLeaderBoard.driverRankings();

        // verify
        assertEquals(Set.of(driver1, driver2, driver3), rankings);
        // note: the order of driver1 and driver2 is JDK/platform dependent
    }

}
