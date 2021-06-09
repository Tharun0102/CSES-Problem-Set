package IntroductoryProblems;

import java.util.*;
import java.io.*;

public class ChessBoardAndQueens {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    char[][] grid = new char[8][8];
    for (int i = 0; i < 8; i++) {
      grid[i] = sc.next().toCharArray();
    }
    boolean[][] visited = new boolean[8][8];
    out.println(solve(0, 0, 0, grid, visited));
    sc.close();
    out.close();
  }

  private static int solve(int r, int c, int placed, char[][] grid, boolean[][] visited) {
    if (placed == grid.length) {
      return 1;
    }
    if (r >= grid.length || c >= grid[0].length) {
      return 0;
    }
    if (grid[r][c] == '*' || !canPlace(r, c, visited)) {
      return solve(r, c + 1, placed, grid, visited);
    }

    visited[r][c] = true;
    int res = solve(r + 1, 0, placed + 1, grid, visited);
    visited[r][c] = false;
    res += solve(r, c + 1, placed, grid, visited);
    return res;
  }

  private static boolean canPlace(int r, int c, boolean[][] visited) {
    // col check
    int i = r;
    while (i >= 0) {
      if (visited[i][c])
        return false;
      i--;
    }
    // diagonal check
    i = r;
    int j = c;
    while (i >= 0 && j >= 0) {
      if (visited[i][j])
        return false;
      i--;
      j--;
    }
    i = r;
    j = c;
    while (i >= 0 && j < visited.length) {
      if (visited[i][j])
        return false;
      i--;
      j++;
    }
    return true;
  }
}