import java.util.*;

public class gridPaths {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // input
    int n = sc.nextInt();
    int mod = (int) 1e9 + 7;
    int[][] grid = new int[n][n];
    for (int i = 0; i < n; i++) {
      char[] row = sc.next().toCharArray();
      for (int j = 0; j < n; j++) {
        grid[i][j] = row[j] == '.' ? 1 : 0;
      }
    }
    if (grid[n - 1][n - 1] == 0) {
      System.out.println(0);
      sc.close();
      return;
    }
    int[][] dp = new int[n][n];
    dp[n - 1][n - 1] = 1;
    // compute bottom most row
    for (int j = n - 2; j >= 0; j--) {
      if (grid[n - 1][j] == 0)
        break;
      dp[n - 1][j] = dp[n - 1][j + 1];
    }
    // compute right most col
    for (int i = n - 2; i >= 0; i--) {
      if (grid[i][n - 1] == 0)
        break;
      dp[i][n - 1] = dp[i + 1][n - 1];
    }
    // fill dp table
    for (int i = n - 2; i >= 0; i--) {
      for (int j = n - 2; j >= 0; j--) {
        if (grid[i][j] == 1) {
          dp[i][j] = (dp[i][j + 1] + dp[i + 1][j]) % mod;
        }
      }
    }

    System.out.println(dp[0][0]);

    sc.close();
  }
}