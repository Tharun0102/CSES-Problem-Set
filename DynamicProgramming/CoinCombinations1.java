import java.util.*;

public class CoinCombinations1 {
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
        long[] dp = new long[x + 1];
        dp[0] = 1;
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < n; j++) {
                if (coins[j] > i)
                    break;
                dp[i] += dp[i - coins[j]];
            }
            dp[i] %= mod;
        }
        System.out.println(dp[x]);
        sc.close();
    }
}