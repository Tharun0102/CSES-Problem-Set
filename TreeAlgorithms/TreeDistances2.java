package TreeAlgorithms;

import java.io.*;
import java.util.*;

public class TreeDistances2 {

  public static void main(String args[]) throws IOException {
    Reader sc = new Reader();
    PrintWriter out = new PrintWriter(System.out);
    int n = sc.nextInt();
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n);
    for (int i = 0; i < n; i++)
      adj.add(new ArrayList<>());

    for (int tt = 0; tt < n - 1; tt++) {
      int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
      adj.get(u).add(v);
      adj.get(v).add(u);
    }

    long[] dp_in = new long[n];
    long[] dp_out = new long[n];
    long[] size = new long[n];

    calculate_dp_in(0, -1, adj, dp_in, size);
    calculate_dp_out(0, -1, adj, dp_in, dp_out, size);

    for (int i = 0; i < n; i++)
      out.print((dp_in[i] + dp_out[i]) + " ");
    out.println();
    out.close();
  }

  static void calculate_dp_in(int curr, int par, ArrayList<ArrayList<Integer>> adj, long[] dp_in, long[] size) {
    long s = 1;
    for (int child : adj.get(curr)) {
      if (child == par)
        continue;
      calculate_dp_in(child, curr, adj, dp_in, size);
      s += size[child];
      dp_in[curr] += (size[child] + dp_in[child]);
    }
    size[curr] = s;
  }

  static void calculate_dp_out(int curr, int par, ArrayList<ArrayList<Integer>> adj, long[] dp_in, long[] dp_out,
      long[] size) {
    long total = 0;
    for (int child : adj.get(curr)) {
      if (child != par)
        total += (dp_in[child] + size[child] * 2);
    }
    for (int child : adj.get(curr)) {
      if (child == par)
        continue;
      dp_out[child] = total - (dp_in[child] + size[child] * 2) + dp_out[curr] + (adj.size() - size[curr] + 1);
      calculate_dp_out(child, curr, adj, dp_in, dp_out, size);
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
