package IntroductoryProblems;

import java.util.*;
import java.io.*;

public class creatingStrings {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    char[] s = sc.next().toCharArray();
    HashSet<String> res = new HashSet<>();
    solve(0, s, res);
    ArrayList<String> output = new ArrayList<>(res);
    Collections.sort(output);
    out.println(output.size());
    for (String str : output) {
      out.println(str);
    }
    sc.close();
    out.close();
  }

  private static void solve(int i, char[] s, HashSet<String> res) {
    if (i == s.length) {
      res.add(new String(s));
      return;
    }
    for (int j = i; j < s.length; j++) {
      swap(s, i, j);
      solve(i + 1, s, res);
      swap(s, i, j);
    }
  }

  private static void swap(char[] s, int i, int j) {
    char temp = s[i];
    s[i] = s[j];
    s[j] = temp;
  }
}
