package interview.warmup;

class RepeatedString {

    private RepeatedString() {
    }

    static long repeatedString(String s, long n) {
        final int aInS = (int) s.chars().filter(ch -> ch == 'a').count();
        final int aInLastS = (int) s.subSequence(0, (int) (n % s.length()))
                .chars()
                .filter(ch -> ch == 'a')
                .count();

        return n / s.length() * aInS + aInLastS;
    }
}
