package IntroductoryProblems;

import java.util.*;
import java.io.*;

public class IncreasingArray {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = sc.nextInt();
    long res = 0;
    for (int i = 1; i < n; i++) {
      if (arr[i] < arr[i - 1]) {
        res += arr[i - 1] - arr[i];
        arr[i] = arr[i - 1];
      }
    }
    out.println(res);
    sc.close();
    out.close();
  }
}
