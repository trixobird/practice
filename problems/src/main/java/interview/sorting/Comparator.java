package interview.sorting;

import lombok.Data;

import java.util.Comparator;

@Data
class Player {
    private final String name;
    private final int score;
}

class Checker implements Comparator<Player> {
    @Override
    public int compare(Player a, Player b) {
        if(a.getScore() != b.getScore()) {
            return b.getScore() - a.getScore();
        }
        return a.getName().compareTo(b.getName());
    }
}
