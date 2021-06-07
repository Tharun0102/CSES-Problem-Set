package IntroductoryProblems;

import java.util.*;
import java.io.*;

public class coinPiles {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int t = sc.nextInt();
    while (t-- > 0) {
      int x = sc.nextInt(), y = sc.nextInt();
      if (x > 2 * y || y > 2 * x) {
        out.println("NO");
        continue;
      }
      x %= 3;
      y %= 3;
      if ((x == 1 && y == 2) || (x == 2 && y == 1) || (x == 0 && y == 0))
        out.println("YES");
      else
        out.println("NO");
    }
    sc.close();
    out.close();
  }
}