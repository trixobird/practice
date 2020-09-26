package toptal;

import java.util.HashMap;
import java.util.Map;

public class Test2 {
}

class Main2 {

    public int solution(String S, int[] X, int[] Y) {

        double maxDistance = Double.MAX_VALUE;
        Map<Character, Coord> map = new HashMap<>();
        for (int i = 0; i < X.length; i++) {
            if (!map.containsKey(S.charAt(i))) {
                map.put(S.charAt(i), new Coord(X[i], Y[i], S.charAt(i)));
            } else {
                Coord temp = new Coord(X[i], Y[i], S.charAt(i));
                double existingDist = map.get(S.charAt(i)).dist();
                if (temp.dist() < maxDistance) {
                    maxDistance = existingDist;
                }
                if (temp.dist() == existingDist) {
                    map.remove(S.charAt(i));
                } else if (temp.dist() < existingDist) {
                    map.put(S.charAt(i), temp);
                }
            }
        }
        final double finalMaxDistance = maxDistance;
        int count = (int) map.values().stream().filter(c -> c.dist() <= finalMaxDistance).count();
        return count;
    }

    boolean eq(Coord c1, Coord c2) {
        return Math.abs(c1.getX()) == Math.abs(c2.getX()) &&
                Math.abs(c1.getY()) == Math.abs(c2.getY());
    }
}

 class Coord {
    private int x;
    private int y;
    private Character tag;

    public Coord(final int x, final int y, final Character tag) {
        this.x = x;
        this.y = y;
        this.tag = tag;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

     public Character getTag() {
         return tag;
     }

     public double dist() {
        return x*x + (double)y*y;
    }
}

class Main5 {
    public static void main(String[] args) {
        int[] ints = {2, -1, -4, -3, 3};
        int[] ints1 = {2, -2, 4, 1, -3};
        new Main2().solution("ABDCA", ints, ints1);
    }
}

//    Example test:   ('ABDCA', [2, -1, -4, -3, 3], [2, -2, 4, 1, -3])
//        WRONG ANSWER (got 5 expected 3)
//
//        Example test:   ('ABB', [1, -2, -2], [1, -2, 2])
//        WRONG ANSWER (got 2 expected 1)
//
//        Example test:   ('CCD', [1, -1, 2], [1, -1, -2])
//        WRONG ANSWER (got 2 expected 0)
