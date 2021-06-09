package IntroductoryProblems;

import java.util.*;
import java.io.*;

public class TowerOfHanoi {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int n = sc.nextInt();
    ArrayList<int[]> moves = new ArrayList<>();
    solve(n, 1, 2, 3, moves);
    out.println(moves.size());
    for (int[] move : moves) {
      out.println(move[0] + " " + move[1]);
    }
    sc.close();
    out.close();
  }

  private static void solve(int n, int left, int middle, int right, ArrayList<int[]> moves) {
    if (n == 1) {
      moves.add(new int[] { left, right });
      return;
    }
    solve(n - 1, left, right, middle, moves);
    moves.add(new int[] { left, right });
    solve(n - 1, middle, left, right, moves);
  }
}
