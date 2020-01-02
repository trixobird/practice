package wallethub;

class CoinDeterminer {

    private CoinDeterminer() {
    }

    static int coinDeterminer(int num) {

        int yp = num % 11;

        if (num <= 10) {
            return transform(yp);
        }

        int res = num / 11 - 1;
        return res + transform(yp + 11);
    }

    private static int transform(int yp) {
        switch (yp) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 1;
            case 6:
                return 2;
            case 7:
                return 1;
            case 8:
                return 2;
            case 9:
                return 1;
            case 10:
                return 2;
            case 11:
                return 1;
            case 12:
                return 2;
            case 13:
                return 3;
            case 14:
                return 2;
            case 15:
                return 3;
            case 16:
                return 2;
            case 17:
                return 3;
            case 18:
                return 2;
            case 19:
                return 3;
            case 20:
                return 2;
            case 21:
                return 3;
            case 22:
                return 2;
            default:
                throw new IllegalStateException();
        }
    }
}
