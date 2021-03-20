import java.util.*;
import java.io.*;

public class RemovingDigits {
    static Reader sc;
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws FileNotFoundException {
        sc = new Reader();
        // input
        int n = sc.ni();
        // 1.using dp table
        // int[] dp = new int[n + 1];
        // dp[0] = 0;
        // for (int i = 1; i <= n; i++) {
        // int mask = 1;
        // dp[i] = 9999999;
        // while (mask <= i) {
        // int dig = (i / mask) % 10;
        // // out.println(i + " " + dig);
        // dp[i] = Math.min(dp[i], 1 + dp[i - dig]);
        // mask *= 10;
        // }
        // }
        // out.println(dp[n]);

        // 2.without dp table
        int result = 1;
        while (n >= 10) {
            int largestDigit = 0;
            // find largest digit
            int temp = n;
            while (temp > 0) {
                int currDigit = temp % 10;
                largestDigit = Math.max(largestDigit, currDigit);
                temp /= 10;
            }
            n -= largestDigit;
            result++;
        }
        out.println(result);
        out.close();
    }

    static void shuffleSort(int[] arr) {
        // shuffle
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            int j = rand.nextInt(i + 1);
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
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

        int ni() {
            return Integer.parseInt(next());
        }

        long nl() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        int[] nai(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = ni();
            return a;
        }

        long[] nal(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nl();
            return a;
        }

        char[][] nmc(int n, int m) {
            char[][] map = new char[n][m];
            for (int i = 0; i < n; i++) {
                String str = sc.next();
                for (int j = 0; j < m; j++) {
                    map[i][j] = str.charAt(j);
                }
            }
            return map;
        }

        int[][] nmi(int n, int m) {
            int[][] map = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = ni();
                }
            }
            return map;
        }

        long[][] nml(int n, int m) {
            long[][] map = new long[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = nl();
                }
            }
            return map;
        }
    }

}