package IntroductoryProblems;

import java.util.*;
import java.io.*;

public class NumberSpiral {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int t = sc.nextInt();
    while (t-- > 0) {
      long r = sc.nextLong(), c = sc.nextLong();
      long res = 0;
      if (r >= c) {
        long diagonalElement = r * r - r + 1;
        long diff = r - c;
        if (r % 2 == 0) {
          res = diagonalElement + diff;
        } else {
          res = diagonalElement - diff;
        }
      } else {
        long diagonalElement = c * c - c + 1;
        long diff = c - r;
        if (c % 2 == 0) {
          res = diagonalElement - diff;
        } else {
          res = diagonalElement + diff;
        }
      }
      out.println(res);

    }
    sc.close();
    out.close();
  }
}
