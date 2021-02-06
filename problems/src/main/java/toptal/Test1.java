package toptal;

import java.util.LinkedList;
import java.util.List;

class Solution1 {
    public int solution(String s, int k) {

        if (s.length() == 1) {
            return 1;
        }

        int max = 0;
        List<Pair> num = new LinkedList<>();
        int freq = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i -1) == s.charAt(i)) {
                freq++;
            } else {
                if (freq > max) {
                    max = freq;
                }
                num.add(new Pair(freq, s.charAt(i - 1)));
                freq = 1;
            }
        }
        num.add(new Pair(freq, s.charAt(s.length() - 1)));
        if (freq > max) {
            max = freq;
        }

        for (int i = 1; i < num.size(); i++) {
            Integer test = test(num, i, k);
            if (test != null &&
                    num.get(test).theChar == num.get(i).theChar &&
                    num.get(test).freq + num.get(i).freq > max) {
                max = num.get(test).freq + num.get(i).freq;
            }
        }
        return max;
    }

    private Integer test(List<Pair> pairs, int idx, int k) {
        if (pairs.get(idx).freq < k) {
            int diff = k - pairs.get(idx).freq;
            if (idx + 1 > pairs.size() - 1) {
                return test(pairs, idx + 1, diff);
            } else {
                return null;
            }
        } else if (pairs.get(idx).freq == k) {
            return idx + 1;
        }
        return null;
    }
}

class Pair {
    int freq;
    char theChar;

    public Pair(final int freq, final char theChar) {
        this.freq = freq;
        this.theChar = theChar;
    }
}

class Main1 {
    public static void main(String[] args) {
        new Solution1().solution("AAAAAAAAAAABXXAAAAAAAAAA", 2);
    }
}

//    Example test:   ('ABBBCCDDCCC', 3)
//        Output (stderr):
//        Exception in thread "main" java.lang.IndexOutOfBoundsException: Index: 5, Size: 5
//        at java.base/java.util.LinkedList.checkElementIndex(LinkedList.java:559)
//        at java.base/java.util.LinkedList.get(LinkedList.java:480)
//        at Solution.solution(Solution.java:38)
//        at Exec.run(exec.java:49)
//        at Exec.main(exec.java:35)
//        RUNTIME ERROR (tested program terminated with exit code 1)
//
//        Example test:   ('AAAAAAAAAAABXXAAAAAAAAAA', 3)
//        WRONG ANSWER (got 11 expected 3)
//
//        Example test:   ('ABCDDDEFG', 2)
//        Output (stderr):
//        Exception in thread "main" java.lang.IndexOutOfBoundsException: Index: 7, Size: 7
//        at java.base/java.util.LinkedList.checkElementIndex(LinkedList.java:559)
//        at java.base/java.util.LinkedList.get(LinkedList.java:480)
//        at Solution.test(Solution.java:47)
//        at Solution.test(Solution.java:50)
//        at Solution.solution(Solution.java:36)
//        at Exec.run(exec.java:49)
//        at Exec.main(exec.java:35)
//        RUNTIME ERROR (tested program terminated with exit code 1)