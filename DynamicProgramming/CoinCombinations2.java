package DynamicProgramming;

import java.util.*;

public class CoinCombinations2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // input
        int n = sc.nextInt(), x = sc.nextInt();
        int mod = (int) 1e9 + 7;
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        Arrays.sort(coins);
        int[][] dp = new int[x + 1][n + 1];
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
                if (i >= coins[j - 1])
                    dp[i][j] = (dp[i][j] + dp[i - coins[j - 1]][j]) % mod;
            }
        }
        System.out.println(dp[x][n]);
        sc.close();
    }
}