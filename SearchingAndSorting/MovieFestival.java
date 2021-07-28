package SearchingAndSorting;

import java.util.*;
import java.io.*;

public class MovieFestival {
  public static void main(String[] args) {
    Reader sc = new Reader();
    PrintWriter out = new PrintWriter(System.out);
    int n = sc.nextInt();
    int[][] intervals = new int[n][2];
    for (int i = 0; i < n; i++) {
      intervals[i][0] = sc.nextInt();
      intervals[i][1] = sc.nextInt();
    }

    Arrays.sort(intervals, (x, y) -> x[1] - y[1]);

    int prevEnd = 0, ans = 0;
    for (int[] interval : intervals) {
      if (interval[0] >= prevEnd) {
        ans++;
        prevEnd = Math.max(prevEnd, interval[1]);
      }
    }
    out.println(ans);
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
