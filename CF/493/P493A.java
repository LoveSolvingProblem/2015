import java.util.*;
import java.io.*;

public class P493A {

	private static void solve() {
		String h = next();
		String a = next();
		int n = nextInt();
		int[] hstatus = new int[100];
		int[] astatus = new int[100];
		for (int i = 0; i < n; i++) {
			int t = nextInt();
			String team = next();
			int p = nextInt();
			String c = next();
			if (team.equals("h")) {
				if (hstatus[p] < 2) {
					hstatus[p] += (c.equals("y") ? 1 : 2);
					if (hstatus[p] >= 2) {
						System.out.println(h + " " + p + " " + t);
					}
				}
			}
			else {
				if (astatus[p] < 2) {
					astatus[p] += (c.equals("y") ? 1 : 2);
					if (astatus[p] >= 2) {
						System.out.println(a + " " + p + " " + t);
					}
				}
			}
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