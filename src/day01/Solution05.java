package day01;

public class Solution05 {
    public int calculateMinimumHP(int[][] dungeon) {
        int sum = 0;
        for (int i = 0; i < dungeon.length; i++) {
            for (int j = 0; j < dungeon[i].length; j++) {
                if (dungeon[i][j] < 0) {
                    sum += dungeon[i][j];
                }
            }
        }
        int left = 1;
        int right = -sum + 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (check(mid, dungeon)) {
                if (!check(mid - 1, dungeon)) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else {
                left = mid + 1;
            }
        }
        return 1;
    }

    public boolean check(int startNum, int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        boolean[][] check = new boolean[dungeon.length][dungeon[0].length];
        for (int i = 0; i < dungeon.length; i++) {
            if (i == 0) {
                if (startNum + dungeon[0][0] <= 0) {
                    break;
                } else {
                    dp[0][0] = startNum + dungeon[0][0];
                    check[0][0] = true;
                }
            } else {
                if (dp[i - 1][0] + dungeon[i][0] <= 0) {
                    break;
                } else {
                    dp[i][0] = dp[i - 1][0] + dungeon[i][0];
                    check[i][0] = true;
                }
            }
        }

        for (int i = 0; i < dungeon[0].length; i++) {
            if (i == 0) {
                if (startNum + dungeon[0][0] <= 0) {
                    break;
                } else {
                    dp[0][0] = startNum + dungeon[0][0];
                    check[0][0] = true;
                }
            } else {
                if (dp[0][i - 1] + dungeon[0][i] <= 0) {
                    break;
                } else {
                    dp[0][i] = dp[0][i - 1] + dungeon[0][i];
                    check[0][i] = true;
                }
            }
        }

        for (int i = 1; i < dungeon.length; i++) {
            for (int j = 1; j < dungeon[0].length; j++) {
                if (check[i - 1][j] && check[i][j - 1]) {
                    if (Math.max(dp[i - 1][j], dp[i][j - 1]) + dungeon[i][j] > 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + dungeon[i][j];
                        check[i][j] = true;
                    }
                } else if (check[i - 1][j]) {
                    if (dp[i - 1][j] + dungeon[i][j] > 0) {
                        dp[i][j] = dp[i - 1][j] + dungeon[i][j];
                        check[i][j] = true;
                    }
                } else if (check[i][j - 1]) {
                    if (dp[i][j - 1] + dungeon[i][j] > 0) {
                        dp[i][j] = dp[i][j - 1] + dungeon[i][j];
                        check[i][j] = true;
                    }
                }
            }
        }
        return check[dungeon.length - 1][dungeon[0].length - 1];
    }
}
