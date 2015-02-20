import java.util.*;
import java.io.*;

public class P489A {

	private static void solve() {
		int n = nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = nextInt();
		}

		StringBuilder builder = new StringBuilder();
		int count = 0;
		for (int i = 0; i < n; i++) {
			int min = a[i];
			int mini = i;
			for (int j = i + 1; j < n; j++) {
				if (min > a[j]) {
					min = a[j];
					mini = j;
				}
			}
			if (min != a[i]) {
				a[mini] = a[i];
				a[i] = min;
				count++;
				builder.append(i + " " + mini + "\r\n");
			}
		}
		System.out.println(count);
		System.out.println(builder.toString());
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