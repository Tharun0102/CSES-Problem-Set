package TreeAlgorithms;

import java.io.*;
import java.util.*;

class Node {
  int id, size;
  ArrayList<Node> adj = new ArrayList<>();

  Node(int id) {
    this.id = id;
  }

  void dfs_size() {
    int s = 1;
    for (Node child : adj) {
      child.dfs_size();
      s += child.size;
    }
    this.size = s;
  }
}

public class Subordinates {
  public static void main(String[] args) throws IOException {
    Reader sc = new Reader();
    PrintWriter out = new PrintWriter(System.out);
    int n = sc.nextInt();
    Node[] nodes = new Node[n];
    for (int i = 0; i < n; i++)
      nodes[i] = new Node(i);

    for (int i = 1; i <= n - 1; i++) {
      int par = sc.nextInt() - 1;
      nodes[par].adj.add(nodes[i]);
    }

    nodes[0].dfs_size();
    for (int i = 0; i < n; i++)
      out.print((nodes[i].size - 1) + " ");
    out.println();
    out.close();
  }

  static class Reader {
    BufferedReader br;
    StringTokenizer st;

    Reader() {
      br = new BufferedReader(new InputStreamReader(System.in));
      st = new StringTokenizer("");
    }

    Reader(File f) throws FileNotFoundException {
      br = new BufferedReader(new FileReader(f));
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
