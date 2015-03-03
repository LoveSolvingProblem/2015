import java.util.*;
import java.io.*;

public class P490A {

	private static void solve() {
		int n = nextInt();
		int[] t1s = new int[n + 1];
		int[] t2s = new int[n + 1];
		int[] t3s = new int[n + 1];
		int t1 = 1, t2 = 1, t3 = 1;

		int j = 1;
		for (int i = 0; i < n; i++) {
			int v = nextInt();
			if (v == 1) {
				t1s[t1++] = j;
			}
			if (v == 2) {
				t2s[t2++] = j;
			}
			if (v == 3) {
				t3s[t3++] = j;
			}
			j++;
		}
		int result = Math.min(t1, Math.min(t2, t3)) - 1;
		System.out.println(result);
		for (int i1 = 1, i2 = 1, i3 = 1; i1 < t1 && i2 < t2 && i3 < t3; i1++, i2++, i3++) {
			System.out.println(t1s[i1] + " " + t2s[i2] + " " + t3s[i3]);
		}
	}

	private static void run() {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);

		solve();

		out.close();
	}

	private static StringTokenizer st;
	private static BufferedReader br;
	private static PrintWriter out;

	private static String next() {
		while (st == null || !st.hasMoreElements()) {
			String s;
			try {
				s = br.readLine();
			} catch (IOException e) {
				return null;
			}
			st = new StringTokenizer(s);
		}
		return st.nextToken();
	}

	private static int nextInt() {
		return Integer.parseInt(next());
	}

	private static long nextLong() {
		return Long.parseLong(next());
	}

	String nextLine() {
		try {
			return br.readLine();
		} catch (IOException e) {
			return null;
		}
	}

	double nextDouble() {
		return Double.parseDouble(next());
	}

	public static void main(String[] args) {
		run();
	}
}