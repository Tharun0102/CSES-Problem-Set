package IntroductoryProblems;

import java.util.*;
import java.io.*;

public class missingNumber {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = sc.nextInt();
    int xor = 0;
    for (int i = 1; i <= n; i++) {
      xor ^= i;
    }
    for (int i = 0; i < n - 1; i++) {
      xor ^= sc.nextInt();
    }
    out.println(xor);
    sc.close();
    out.close();
  }
}
