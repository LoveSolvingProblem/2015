import java.util.*;
import java.io.*;

public class P490B {

	static final int MAX = 1000000 + 1;

	private static void solve() {
		int n = nextInt();
		int[] map = new int[MAX];
		int[] sMap = new int[MAX];

		for (int i = 0; i < n; i++) {
			int f = nextInt();
			int s = nextInt();

			sMap[s]++;
			map[f] = s == 0 ? -1 : s;
		}
		int old = 0;
		for (int i = 1; i < MAX; i++) {
			if (map[i] != 0 && sMap[i] == 0) {
				old = i;
				break;
			}
		}
		StringBuilder result = new StringBuilder();
		result.append(old + " ");
		int even = 0;
		int len2 = n / 2 + 1;
		for (int i = 0; i < len2; i++) {
			if (even < MAX && map[even] > 0) {
				even = map[even];
				result.append(even + " ");
			}
			if (old < MAX && map[old] > 0) {
				old = map[old];
				result.append(old + " ");
			}
		}
		System.out.println(result.toString());
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