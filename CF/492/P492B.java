import java.util.*;
import java.io.*;

public class P492B {

	private static void solve() {
		int n = nextInt();
		int l = nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = nextInt();
		}
		Arrays.sort(a);
		double max = 0;
		for (int i = 1; i < n; i++) {
			if (a[i] - a[i - 1] > max) {
				max = a[i] - a[i - 1];
			}
		}

		max = Math.max(max / 2, Math.max(a[0], l - a[n - 1]));
		System.out.println(max);
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