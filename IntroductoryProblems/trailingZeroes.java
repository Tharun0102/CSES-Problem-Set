package IntroductoryProblems;

import java.util.*;
import java.io.*;

public class trailingZeroes {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    long n = sc.nextLong();
    int res = 0;
    long curr = 5;
    while (n >= curr) {
      res += (n / curr);
      curr *= 5;
    }
    out.println(res);
    sc.close();
    out.close();
  }
}
