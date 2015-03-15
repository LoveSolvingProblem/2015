import java.util.*;
import java.io.*;

public class P493B {

	private static void solve() {
		int MAX = 200000 + 1;
		long[] fs = new long[MAX];
		long[] ss = new long[MAX];

		int n = nextInt();
		int f = 0;
		int s = 0;
		int last = 0;
		long totalf = 0;
		long totals = 0;
		for (int i = 0; i < n; i++) {
			long a = nextInt();
			if (a > 0) {
				fs[f++] = a;
				totalf += a;
				last = 1;
			}
			else {
				ss[s++] = -a;
				totals += (-a);
				last = 2;
			}
		}
		String win = "";
		if (totalf > totals) {
			win = "first";
		}
		else if (totals > totalf) {
			win = "second";
		}
		else {
			for (int i = 0; i < f; i++) {
				if (fs[i] > ss[i]) {
					win = "first";
					break;
				}
				else if (fs[i] < ss[i]) {
					win = "second";
					break;
				}
			}
			if (win.equals("")) {
				if (last == 1) {
					win = "first";
				}
				else {
					win = "second";
				}
			}
		}
		System.out.println(win);
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