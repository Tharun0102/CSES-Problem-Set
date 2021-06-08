package IntroductoryProblems;

import java.util.*;
import java.io.*;

public class PalindromeReorder {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);

    char[] s = sc.next().toCharArray();
    int n = s.length;
    int[] freq = new int[26];
    for (char c : s)
      freq[c - 'A']++;
    int oddFreq = 0;
    for (int f : freq) {
      if (f % 2 != 0)
        oddFreq++;
    }

    if ((n % 2 == 0 && oddFreq > 0) || (n % 2 != 0 && oddFreq > 1)) {
      out.println("NO SOLUTION");
    } else {
      char[] res = new char[n];
      int i = 0, j = n - 1;
      int oddi = -1, oddVal = 0;
      for (int k = 0; k < 26; k++) {
        if (freq[k] % 2 != 0) {
          oddi = k;
          oddVal = freq[k];
          continue;
        }
        char ch = (char) ('A' + k);
        while (freq[k] > 0) {
          res[i++] = ch;
          res[j--] = ch;
          freq[k] -= 2;
        }
      }
      // for the odd freq element
      if (oddi != -1) {
        char ch = (char) ('A' + oddi);
        while (oddVal > 1) {
          res[i++] = ch;
          res[j--] = ch;
          oddVal -= 2;
        }
        res[i] = ch;
      }
      out.println(new String(res));
    }

    sc.close();
    out.close();
  }
}