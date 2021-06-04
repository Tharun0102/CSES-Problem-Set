package IntroductoryProblems;

import java.util.*;
import java.io.*;

public class Permutations {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = sc.nextInt();
    if (n == 1) {
      out.println(1);
    } else if (n < 4) {
      out.println("NO SOLUTION");
    } else {
      for (int i = 2; i <= n; i += 2)
        out.print(i + " ");
      for (int i = 1; i <= n; i += 2)
        out.print(i + " ");
    }

    sc.close();
    out.close();
  }
}
