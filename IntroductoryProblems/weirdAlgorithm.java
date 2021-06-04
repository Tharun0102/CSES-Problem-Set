package IntroductoryProblems;

import java.util.*;
import java.io.*;

public class weirdAlgorithm {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    long n = sc.nextLong();
    while (n != 1) {
      out.print(n + " ");
      if (n % 2 == 0) {
        n = n / 2;
      } else {
        n = 3 * n + 1;
      }
    }
    out.println(1);
    sc.close();
    out.close();
  }
}
