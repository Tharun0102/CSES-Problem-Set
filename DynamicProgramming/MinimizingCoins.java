package DynamicProgramming;

import java.util.*;

public class MinimizingCoins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // input
        int n = sc.nextInt(), x = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        Arrays.sort(coins);
        int[] dp = new int[x + 1];
        dp[0] = 0;
        for (int i = 1; i <= x; i++) {
            int minimum = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (coins[j] > i)
                    break;
                minimum = Math.min(minimum, dp[i - coins[j]]);
            }
            dp[i] = (minimum == Integer.MAX_VALUE) ? minimum : 1 + minimum;
        }
        System.out.println((dp[x] == Integer.MAX_VALUE) ? -1 : dp[x]);
        sc.close();
    }
}