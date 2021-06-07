package IntroductoryProblems;

import java.util.*;
import java.io.*;

public class twoSets {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = sc.nextInt();
    long total = (long) n * (n + 1) / 2;
    if (total % 2 != 0) {
      out.println("NO");
      sc.close();
      out.close();
      return;
    }
    boolean[] visited = new boolean[n + 1];
    long sum1 = total / 2, vis = 0;
    for (int i = n; i > 0; i--) {
      if (sum1 - i >= 0) {
        sum1 -= i;
        visited[i] = true;
        vis++;
      }
    }
    if (sum1 != 0) {
      out.println("NO");
    } else {
      out.println("YES");
      out.println(vis);
      for (int i = 1; i <= n; i++) {
        if (visited[i])
          out.print(i + " ");
      }
      out.println();
      out.println(n - vis);
      for (int i = 1; i <= n; i++) {
        if (!visited[i])
          out.print(i + " ");
      }
      out.println();
    }
    sc.close();
    out.close();
  }
}
