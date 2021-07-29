package TreeAlgorithms;

import java.io.*;
import java.util.*;

public class TreeDistances1 {

  public static void main(String args[]) throws IOException {
    Reader sc = new Reader();
    PrintWriter out = new PrintWriter(System.out);
    int n = sc.nextInt();
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n);
    for (int i = 0; i < n; i++)
      adj.add(new ArrayList<>());
    int[] distance = new int[n];

    for (int tt = 0; tt < n - 1; tt++) {
      int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
      adj.get(u).add(v);
      adj.get(v).add(u);
    }

    int end1 = bfs(0, adj, distance);
    int end2 = bfs(end1, adj, distance);
    bfs(end2, adj, distance);

    for (int e : distance)
      out.print(e + " ");
    out.println();
    out.close();
  }

  static int bfs(int i, ArrayList<ArrayList<Integer>> adj, int[] distance) {
    Queue<Integer> q = new LinkedList<>();
    boolean[] vis = new boolean[adj.size()];
    q.add(i);
    vis[i] = true;
    int d = 0, last = -1;
    while (!q.isEmpty()) {
      int size = q.size();
      while (size-- > 0) {
        int curr = q.remove();
        distance[curr] = Math.max(distance[curr], d);
        last = curr;
        for (int child : adj.get(curr)) {
          if (!vis[child]) {
            vis[child] = true;
            q.add(child);
          }
        }
      }
      d++;
    }
    return last;
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
