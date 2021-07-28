package SearchingAndSorting;

import java.util.*;
import java.io.*;

public class Apartments {
  public static void main(String[] args) {
    Reader sc = new Reader();
    PrintWriter out = new PrintWriter(System.out);
    int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
    int[] a = new int[n], b = new int[m];
    for (int i = 0; i < n; i++)
      a[i] = sc.nextInt();
    for (int i = 0; i < m; i++)
      b[i] = sc.nextInt();

    shuffleSort(a);
    shuffleSort(b);
    int i = 0, j = 0, ans = 0;
    while (i < n && j < m) {
      if (Math.abs(a[i] - b[j]) <= k) {
        ans++;
        i++;
        j++;
      } else if (a[i] < b[j]) {
        i++;
      } else {
        j++;
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
