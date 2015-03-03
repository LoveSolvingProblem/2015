import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int S1 = sc.nextInt();
		int S2 = sc.nextInt();
		int Q = sc.nextInt();
		double sqrt2 = Math.sqrt(2);
		for (int i = 0; i < Q; i++) {
			long q = sc.nextLong();
			System.out.println((L - Math.sqrt(q)) / (Math.abs(S1 - S2) / sqrt2));
		}
	}
}