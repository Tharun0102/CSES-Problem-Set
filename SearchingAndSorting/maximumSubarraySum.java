package SearchingAndSorting;

import java.util.*;
import java.io.*;

public class maximumSubarraySum {
  public static void main(String[] args) {
    Reader sc = new Reader();
    PrintWriter out = new PrintWriter(System.out);
    int n = sc.nextInt();
    long[] arr = new long[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextLong();
    }

    long max = arr[0], curr = 0;
    for (long e : arr) {
      curr += e;
      if (curr < e) {
        curr = e;
      }
      max = Math.max(max, curr);
    }
    out.println(max);
    out.close();
  }

  static void shuffleSort(int[] arr) {
    int n = arr.length;
    Random rnd = new Random();
    for (int i = 0; i < n; ++i) {
      int tmp = arr[i];
      int randomPos = i + rnd.nextInt(n - i);
      arr[i] = arr[randomPos];
      arr[randomPos] = tmp;
    }
    Arrays.sort(arr);
  }

  static class Reader {
    BufferedReader br;
    StringTokenizer st;

    Reader() {
      br = new BufferedReader(new InputStreamReader(System.in));
      st = new StringTokenizer("");
    }

    String next() {
      while (!st.hasMoreTokens())
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
        }
      return st.nextToken();
    }

    int nextInt() {
      return Integer.parseInt(next());
    }

    long nextLong() {
      return Long.parseLong(next());
    }

    double nextDouble() {
      return Double.parseDouble(next());
    }
  }

}
