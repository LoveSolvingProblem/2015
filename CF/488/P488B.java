import java.util.*;
import java.io.*;

public class P488B {

	private static void solve() {
		int n = nextInt();
		if (n == 0) {
			System.out.println("YES");
			System.out.println(1);
			System.out.println(2);
			System.out.println(2);
			System.out.println(3);
			return;
		}
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = nextInt();
		}
		Arrays.sort(a);
		if (n == 1) {
			System.out.println("YES");
			System.out.println(2 * a[0]);
			System.out.println(2 * a[0]);
			System.out.println(3 * a[0]);
			return;
		}
		if (n == 2) {
			int a1 = a[0];
			int a2 = a[1];
			if (3 * a1 == a2) {
				System.out.println("YES");
				System.out.println(2 * a1);
				System.out.println(2 * a1);
				return;
			}

			int sum = a1 + a2;
			if (sum % 4 == 0 && sum / 4 <= a1) {
				System.out.println("YES");
				System.out.println(sum / 4);
				System.out.println(sum * 3 / 4);
				return;
			}

			if (a2 <= 3 * a1) {
				System.out.println("YES");
				System.out.println(4 * a1 - a2);
				System.out.println(3 * a1);
				return;
			}

			if (a2 % 3 == 0 && a2 / 3 <= a1) {
				System.out.println("YES");
				System.out.println(a2 / 3);
				System.out.println(a2 * 4 / 3 - a1);
				return;
			}

			System.out.println("NO");
		}
		if (n == 4) {
			if (a[0] + a[3] == a[1] + a[2] && a[3] == 3 * a[0]) {
				System.out.println("YES");
				return;
			}
			System.out.println("NO");
		}
		if (n == 3) {
			int a1 = a[0];
			int a2 = a[1];
			int a3 = a[2];

			if (a2 + a3 == 4 * a1) {
				System.out.println("YES");
				System.out.println(3 * a1);
				return;
			}
			if (a3 % 3 == 0 && a3 / 3 * 4 == a1 + a2) {
				System.out.println("YES");
				System.out.println(a3 / 3);
				return;
			}
			if (3 * a1 == a3) {
				System.out.println("YES");
				System.out.println(4 * a1 - a2);
				return;
			}
			System.out.println("NO");
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