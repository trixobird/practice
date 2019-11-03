package interview.other;

class Jafar {

    int solution(String[] b) {

        if (b.length < 2) {
            return 0;
        }

        Point jafar = new Point(0, 0);
        for (int i = 0; i < b.length; i++) {
            int idx = b[i].indexOf('O');
            if (idx != -1) {
                jafar = new Point(idx, i);
            }
        }

        return beat(b, jafar);
    }

    private int beat(String[] b, Point jafar) {
        int left = 0;
        int right = 0;
        if (jafar.getY() < 2) {
            return 0;
        }
        if ((jafar.getX() > 1 && b[jafar.getY() - 1].charAt(jafar.getX() - 1) == 'X')
            && (jafar.getY() == 1 || jafar.getX() == 1 || b[jafar.getY() - 2].charAt(jafar.getX() - 2) == '.')) {
            left = beat(b, new Point(jafar.getX() - 2, jafar.getY() - 2)) + 1;
        }
        if ((jafar.getX() < b.length - 2 && b[jafar.getY() - 1].charAt(jafar.getX() + 1) == 'X')
            && (jafar.getY() == 1 || jafar.getX() == b.length - 2 || b[jafar.getY() - 2].charAt(jafar.getX() + 2) == '.')) {
            right = beat(b, new Point(jafar.getX() + 2, jafar.getY() - 2)) + 1;
        }

        return Math.max(left, right);
    }
}

class Point {
    private final int x;
    private final int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }
}
