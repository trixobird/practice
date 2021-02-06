package microsoft;

public class Task2 {

    public static int solution(int[] A) {

        int max = 0;
        boolean found = false;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (getDigitsSum(A[i]) == getDigitsSum(A[j])) {
                    found = true;
                    int tmp = A[i] + A[j];
                    if (tmp > max) {
                        max = tmp;
                    }
                }
            }
        }

        if (found) {
            return max;
        } else {
            return -1;
        }
    }

    private static int getDigitsSum (int number) {

        int sum = 0;
        while (number > 0) {
            sum+= (number % 10);
            number = number / 10;
        }
        return sum;
    }
}
