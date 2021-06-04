package IntroductoryProblems;

import java.util.*;
import java.io.*;

public class Repetitions {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    char[] s = sc.next().toCharArray();
    int res = 1, curr = 1;
    for (int i = 1; i < s.length; i++) {
      if (s[i] == s[i - 1]) {
        curr++;
      } else {
        curr = 1;
      }
      res = Math.max(res, curr);
    }
    out.println(res);
    sc.close();
    out.close();
  }
}
