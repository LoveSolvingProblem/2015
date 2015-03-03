import java.util.*;
import java.io.*;

public class P488A {

	private static void solve() {
		int n = nextInt();
		for (int i = 1; i < 100; i++) {
			if (check(n + i)) {
				System.out.println(i);
				return;
			}
		}
	}

	static private boolean check(int n) {
		if (n < 0) {
			n = -n;
		}
		while (n != 0) {
			if (n % 10 == 8)
				return true;
			n /= 10;
		}
		return false;
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