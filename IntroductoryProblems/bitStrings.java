package IntroductoryProblems;

import java.util.*;
import java.io.*;

public class bitStrings {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    long n = sc.nextLong(), mod = (long) 1e9 + 7;
    out.println(pow(2, n, mod));
    sc.close();
    out.close();
  }

  private static long pow(long x, long y, long mod) {
    if (y == 0) {
      return 1;
    }
    long powBy2 = pow(x, y / 2, mod);
    long res = (powBy2 * powBy2) % mod;
    if (y % 2 != 0) {
      res = (res * x) % mod;
    }
    return res;
  }
}