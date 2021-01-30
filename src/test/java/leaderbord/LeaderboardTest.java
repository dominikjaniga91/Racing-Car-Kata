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
        Race race = new Race("Night race", driver1, driver2, driver3);
        Leaderboard leaderboard = new Leaderboard(race);

        //when
        Set<Driver> rankings = leaderboard.driverRankings();

        //then
        Assert.assertEquals(rankings, racers);
    }


    @Test
    public void shouldReturnTheWinner_afterDriverWontTheRace() {
        //given
        Race race = new Race("Night race", driver1, driver2, driver3);
        Leaderboard leaderboard = new Leaderboard(race);

        //when
        Set<Driver> rankings = leaderboard.driverRankings();
        System.out.println(" ranking is " + rankings);

        //then
        Assert.assertEquals(driver1, rankings.iterator().next());
    }


    @Test
    public void itShouldSumThePoints() {
        // setup
        Driver driver1 = new Driver("Nico Rosberg", "DE");
        Driver driver2 = new Driver("Lewis Hamilton", "UK");
        Driver driver3 = new Driver("Sebastian Vettel", "DE");
        Race race1 = new Race("Australian Grand Prix", driver1, driver2, driver3);
        Race race2 = new Race("Malaysian Grand Prix", driver3, driver2, driver1);
        Race race3 = new Race("Chinese Grand Prix", driver2, driver1, driver3);
        Leaderboard leaderboard = new Leaderboard(race1, race2, race3);
        Driver winner = new Driver("Lewis Hamilton", "UK");
        int expected = 61;

        // act
        Set<Driver> results = leaderboard.driverRankings();
        int actual = results.iterator().next().getPoints();
        Driver driver = results.iterator().next();
        System.out.println(" driver " + driver + " points " + driver.getPoints());

        // verify
        assertTrue(results.contains(winner), "results " + results);
        assertEquals(actual, expected);
    }

    @Test
    public void isShouldFindTheWinner() {
        // setup
        Driver winner = new Driver("Lewis Hamilton", "UK");

        // act
        Set<Driver> result = sampleLeaderboard1.driverRankings();

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
    }

}
