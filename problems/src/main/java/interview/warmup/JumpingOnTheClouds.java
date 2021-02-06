package interview.warmup;

class JumpingOnTheClouds {

    private JumpingOnTheClouds() {
    }

    static int jumpingOnClouds(int[] c) {

        int jumps = 0;
        for (int i = 0; i < c.length - 1; i++) {
            if (i == c.length - 2) {
                return ++jumps;
            }
            if (c[i + 2] == 0) {
                i++;
            }
            jumps++;
        }
        return jumps;
    }
}
