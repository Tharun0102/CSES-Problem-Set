package DynamicProgramming;

import java.util.*;

public class RemovingDigits {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // input
    int n = sc.nextInt();

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
    System.out.println(result);

    sc.close();
  }
}