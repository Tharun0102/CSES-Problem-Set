package SearchingAndSorting;

import java.util.*;
import java.io.*;

public class RestaurantCustomers {
  public static void main(String[] args) {
    Reader sc = new Reader();
    PrintWriter out = new PrintWriter(System.out);
    int n = sc.nextInt();
    ArrayList<int[]> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int x = sc.nextInt(), y = sc.nextInt();
      list.add(new int[] { x, 1 });
      list.add(new int[] { y, -1 });
    }

    Collections.sort(list, (x, y) -> x[0] - y[0]);

    int res = 0, curr = 0;
    for (int[] a : list) {
      curr += a[1];
      res = Math.max(res, curr);
    }
    out.println(res);

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
