package microsoft;

public class Task1 {

    public static String solution(String riddle) {

        if (riddle.length() == 1) {
            if (riddle.charAt(0) == '?') {
                return "a";
            }
            return riddle;
        }

        if (riddle.length() == 2) {
            if (riddle.charAt(0) == '?') {
                if (riddle.charAt(1) == 'a' || riddle.charAt(1) == '?') {
                    return "ba";
                } else if (riddle.charAt(1) == 'b') {
                    return "ab";
                }
                return "a" + riddle.charAt(1);
            } else if (riddle.charAt(0) == 'a') {
                if (riddle.charAt(1) == '?') {
                    return "ab";
                } return riddle;
            } else if (riddle.charAt(0) == 'b') {
                if (riddle.charAt(1) == '?') {
                    return "ba";
                } return riddle;
            }
            return riddle;
        }

        char first;
        StringBuilder sb = new StringBuilder();
        if (riddle.charAt(0) != '?') {
            first = riddle.charAt(0);
        } else {
            if (riddle.charAt(1) == 'a') {
                first = 'b';
            } else {
                first = 'a';
            }
        }
        sb.append(first);

        char prev = first;
        for (int i = 1; i < riddle.length() - 1; i++) {
            final char c1 = riddle.charAt(i);
            if (c1 == '?') {
                prev = getNext(prev, riddle.charAt(i + 1));
                sb.append(prev);
            } else {
                sb.append(c1);
                prev = c1;
            }
        }

        if (riddle.charAt(riddle.length() - 1) == '?') {
            if (prev == 'a') {
                sb.append('b');
            } else {
                sb.append('a');
            }
        } else {
            sb.append(riddle.charAt(riddle.length() - 1));
        }

        return sb.toString();
    }


    public static char getNext(char prev, char next) {
        if (prev == next) {
            if (prev == 'a') {
                return 'b';
            } else {
                return 'a';
            }
        }

        if (next == '?') {
            if (prev == 'a') {
                return 'b';
            } else {
                return 'a';
            }
        }

        if (prev == 'b') {
            if (next == 'a') {
                return 'c';
            } else {
                return 'a';
            }
        }

        if (prev == 'a') {
            if (next == 'b') {
                return 'c';
            } else {
                return 'b';
            }
        }

        if (next == 'a') {
            return 'b';
        }
        return 'a';
    }
}
