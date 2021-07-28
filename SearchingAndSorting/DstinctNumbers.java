package SearchingAndSorting;

import java.util.*;
import java.io.*;

public class DstinctNumbers {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = sc.nextInt();
    shuffleSort(arr);
    long res = 1;
    for (int i = 1; i < n; i++) {
      if (arr[i] != arr[i - 1]) {
        res++;
      }
    }
    out.println(res);
    sc.close();
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
}
