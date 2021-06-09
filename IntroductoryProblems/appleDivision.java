package IntroductoryProblems;

import java.util.*;
import java.io.*;

public class appleDivision {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = sc.nextInt();
    long[] p = new long[n];
    for (int i = 0; i < n; i++)
      p[i] = sc.nextLong();
    out.println(solve(0, 0, 0, p));
    sc.close();
    out.close();
  }

  private static long solve(int i, long sum1, long sum2, long[] p) {
    if (i == p.length) {
      return Math.abs(sum1 - sum2);
    }
    return Math.min(solve(i + 1, sum1 + p[i], sum2, p), solve(i + 1, sum1, sum2 + p[i], p));
  }
}