package interview.arrays;

class Hourglass {

    private Hourglass() {
    }

    static int hourglassSum(int[][] arr) {

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr[0].length - 2; i++) {
            for (int j = 0; j < arr.length - 2; j++) {
                int sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }
}
