package TreeAlgorithms;

import java.io.*;
import java.util.*;

public class TreeMatching {
  public static void main(String[] args) throws IOException {
    Reader sc = new Reader();
    PrintWriter out = new PrintWriter(System.out);
    int n = sc.nextInt();
    Node[] nodes = new Node[n];
    for (int i = 0; i < n; i++)
      nodes[i] = new Node(i);

    for (int i = 0; i < n - 1; i++) {
      int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
      nodes[u].adj.add(nodes[v]);
      nodes[v].adj.add(nodes[u]);
    }

    Integer[][] memo = new Integer[n][2];

    int res1 = solve(nodes[0], 0, null, memo);
    int res2 = solve(nodes[0], 1, null, memo);

    out.println(Math.max(res1, res2));
    out.close();
  }

  static int solve(Node curr, int state, Node par, Integer[][] memo) {
    if (curr.adj.size() == 0) {
      // leaf
      return 0;
    }
    if (memo[curr.id][state] != null) {
      return memo[curr.id][state];
    }
    if (state == 0) {
      int res = 0;
      for (Node child : curr.adj) {
        if (child == par)
          continue;
        res += solve(child, 1, curr, memo);
      }
      return memo[curr.id][0] = res;
    } else {
      int notTake = 0;
      for (Node child : curr.adj) {
        if (child == par)
          continue;
        notTake += solve(child, 1, curr, memo);
      }
      int take = 0;
      for (Node child : curr.adj) {
        if (child == par)
          continue;
        take = Math.max(take, 1 + (notTake - solve(child, 1, curr, memo) + solve(child, 0, curr, memo)));
      }
      return memo[curr.id][1] = Math.max(take, notTake);
    }
  }

  static class Node {
    int id;
    ArrayList<Node> adj = new ArrayList<>();

    Node(int id) {
      this.id = id;
    }
  }

  static class Reader {
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader() {
      din = new DataInputStream(System.in);
      buffer = new byte[BUFFER_SIZE];
      bufferPointer = bytesRead = 0;
    }

    public Reader(String file_name) throws IOException {
      din = new DataInputStream(new FileInputStream(file_name));
      buffer = new byte[BUFFER_SIZE];
      bufferPointer = bytesRead = 0;
    }

    public String nextLine() throws IOException {
      byte[] buf = new byte[1000000]; // line length
      int cnt = 0, c;
      while ((c = read()) != -1) {
        if (c == '\n')
          break;
        buf[cnt++] = (byte) c;
      }
      return new String(buf, 0, cnt);
    }

    public int nextInt() throws IOException {
      int ret = 0;
      byte c = read();
      while (c <= ' ')
        c = read();
      boolean neg = (c == '-');
      if (neg)
        c = read();
      do {
        ret = ret * 10 + c - '0';
      } while ((c = read()) >= '0' && c <= '9');
      if (neg)
        return -ret;
      return ret;
    }

    public long nextLong() throws IOException {
      long ret = 0;
      byte c = read();
      while (c <= ' ')
        c = read();
      boolean neg = (c == '-');
      if (neg)
        c = read();
      do {
        ret = ret * 10 + c - '0';
      } while ((c = read()) >= '0' && c <= '9');
      if (neg)
        return -ret;
      return ret;
    }

    public double nextDouble() throws IOException {
      double ret = 0, div = 1;
      byte c = read();
      while (c <= ' ')
        c = read();
      boolean neg = (c == '-');
      if (neg)
        c = read();
      do {
        ret = ret * 10 + c - '0';
      } while ((c = read()) >= '0' && c <= '9');
      if (c == '.') {
        while ((c = read()) >= '0' && c <= '9') {
          ret += (c - '0') / (div *= 10);
        }
      }
      if (neg)
        return -ret;
      return ret;
    }

    private void fillBuffer() throws IOException {
      bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
      if (bytesRead == -1)
        buffer[0] = -1;
    }

    private byte read() throws IOException {
      if (bufferPointer == bytesRead)
        fillBuffer();
      return buffer[bufferPointer++];
    }

    public void close() throws IOException {
      if (din == null)
        return;
      din.close();
    }
  }
}
