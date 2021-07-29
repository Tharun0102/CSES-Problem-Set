package TreeAlgorithms;

import java.io.*;
import java.util.*;

public class TreeDiameter {

  public static void main(String args[]) {
    Reader sc = new Reader();
    PrintWriter out = new PrintWriter(System.out);
    int n = sc.nextInt();
    ArrayList<Integer>[] adj = new ArrayList[n];

    for (int i = 0; i < n; i++)
      adj[i] = new ArrayList<>();
    for (int tt = 0; tt < n - 1; tt++) {
      int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
      adj[u].add(v);
      adj[v].add(u);
    }

    int[] first = bfs(0, adj);
    int[] res = bfs(first[1], adj);
    out.println(res[0]);
    out.close();
  }

  static int[] bfs(int i, ArrayList<Integer>[] adj) {
    Queue<Integer> q = new LinkedList<>();
    boolean[] vis = new boolean[adj.length];
    q.add(i);
    vis[i] = true;
    int len = 0, last = -1;
    while (!q.isEmpty()) {
      int size = q.size();
      while (size-- > 0) {
        int curr = q.remove();
        last = curr;
        for (int child : adj[curr]) {
          if (!vis[child]) {
            vis[child] = true;
            q.add(child);
          }
        }
      }
      len++;
    }
    return new int[] { len - 1, last };
  }

  static class Reader {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer("");

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
  }
}
