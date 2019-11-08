package interview.sorting;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class CheckerTest {

    @Test
    public void compare() {
        List<Player> players = Arrays.asList(new Player("david", 100),
                                             new Player("amy", 100),
                                             new Player("heraldo", 50),
                                             new Player("aakansha", 75),
                                             new Player("aleksa", 150));

        List<Player> collect = players.stream().sorted(new Checker()).collect(Collectors.toList());

        assertThat(collect, contains(new Player("aleksa", 150),
                                     new Player("amy", 100),
                                     new Player("david", 100),
                                     new Player("aakansha", 75),
                                     new Player("heraldo", 50)));
    }
}