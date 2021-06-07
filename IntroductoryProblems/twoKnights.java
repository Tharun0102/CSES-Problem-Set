package IntroductoryProblems;

import java.util.*;
import java.io.*;

public class twoKnights {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = sc.nextInt();
    out.println(0);
    for (int i = 2; i <= n; i++) {
      // total possible positions without overcounting n^2*(n^2-1)/2
      // total 3x2 and 2x3 matrices in nxn matrix are 4*(n-1)*(n-2)
      out.println(((long) (i * i) * (i * i - 1)) / 2 - 4 * (i - 1) * (i - 2));
    }
    sc.close();
    out.close();
  }
}
