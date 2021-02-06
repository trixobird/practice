package toptal;

import java.util.HashMap;
import java.util.Map;

class Main2 {

    public int solution(String s, int[] x, int[] y) {

        double maxDistance = Double.MAX_VALUE;
        Map<Character, Coord> map = new HashMap<>();
        for (int i = 0; i < x.length; i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), new Coord(x[i], y[i]));
            } else {
                Coord temp = new Coord(x[i], y[i]);
                double existingDist = map.get(s.charAt(i)).dist();
                if (temp.dist() < maxDistance) {
                    maxDistance = existingDist;
                }
                if (temp.dist() == existingDist) {
                    map.remove(s.charAt(i));
                } else if (temp.dist() < existingDist) {
                    map.put(s.charAt(i), temp);
                }
            }
        }
        final double finalMaxDistance = maxDistance;
        return (int) map.values().stream().filter(c -> c.dist() <= finalMaxDistance).count();
    }

}

 class Coord {
    private final int x;
    private final int y;

     public Coord(final int x, final int y) {
        this.x = x;
        this.y = y;
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
