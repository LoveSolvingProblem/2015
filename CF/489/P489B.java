import java.util.*;
import java.io.*;

public class P489B {

	private static void solve() {
		int n = nextInt();
		int[] boys = new int[n];
		for (int i = 0; i < n; i++) {
			boys[i] = nextInt();
		}
		Arrays.sort(boys);
		int m = nextInt();
		int[] girls = new int[m];
		for (int i = 0; i < m; i++) {
			girls[i] = nextInt();
		}
		Arrays.sort(girls);
		boolean[] flags = new boolean[m];

		int count = 0;
		for (int b = 0; b < n; b++) {
			for (int g = 0; g < m; g++) {
				if (!flags[g] && Math.abs(boys[b] - girls[g]) <= 1) {
					flags[g] = true;
					count++;
					break;
				}
			}
		}
		System.out.println(count);
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

	public static void main(String[] args) {
		run();
	}
}