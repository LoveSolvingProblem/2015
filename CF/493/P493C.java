import java.util.*;
import java.io.*;

public class P493C {

	private static void solve() {
		ArrayList<C> list = new ArrayList<C>();

		int n = nextInt();
		for (int i = 0; i < n; i++) {
			list.add(new C(1, nextInt()));
		}

		int m = nextInt();
		for (int i = 0; i < m; i++) {
			list.add(new C(2, nextInt()));
		}

		Collections.sort(list);
		int f = n * 3, s = m * 3;
		int maxf = f;
		int maxs = s;
		int max = maxf - maxs;
		int len = n + m;
		for (int i = 0; i < len; i++) {
			C c = list.get(i);
			if (c.t == 1) {
				f -= 1;
			}
			else {
				s -= 1;
			}
			if (i == len - 1 || list.get(i).d < list.get(i + 1).d) {
				if (f - s > max) {
					max = f - s;
					maxf = f;
					maxs = s;
				}
			}
		}

		System.out.println(maxf + ":" + maxs);
	}

	static class C implements Comparable<C>
	{
		public int t = 0;
		public int d = 0;

		public C(int t, int d) {
			this.t = t;
			this.d = d;
		}

		public int compareTo(C arg0) {
			return this.d - arg0.d;
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