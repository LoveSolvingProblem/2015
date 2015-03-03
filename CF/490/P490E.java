import java.util.*;
import java.io.*;

public class P490E {

	static final int MAX = 8;

	private static void solve() {
		int n = nextInt();
		char[] pre = new char[MAX];
		Arrays.fill(pre, '0');
		char[] cur = new char[MAX];
		Arrays.fill(cur, '0');
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < n; i++) {
			String numString = next();
			int digit = numString.length();
			int first = MAX - digit;
			Arrays.fill(cur, '0');
			for (int j = first; j < MAX; j++) {
				cur[j] = numString.charAt(j - first);
			}
			if (cur[first] == '?' && pre[first] == '0') {
				cur[first] = '1';
			}

			int checkPoint = 0;
			while (checkPoint < MAX && (cur[checkPoint] == '?' || cur[checkPoint] == pre[checkPoint])) {
				checkPoint++;
			}

			boolean greater = false;
			if (checkPoint < MAX && cur[checkPoint] > pre[checkPoint]) {
				greater = true;
			}
			for (int j = checkPoint - 1; j >= first; j--) {
				if (cur[j] == '?' && !greater && pre[j] < '9') {
					cur[j] = (char) (pre[j] + 1);
					greater = true;
				}
				else if (cur[j] == '?' && !greater && pre[j] == '9') {
					cur[j] = '0';
				}
				else if (cur[j] == '?') {
					cur[j] = pre[j];
				}
			}

			if (!greater) {
				System.out.println("NO");
				return;
			}

			for (int j = first; j < MAX; j++) {
				if (j > checkPoint && cur[j] == '?') {
					cur[j] = '0';
				}
				result.append(cur[j]);
			}
			result.append("\r\n");
			char[] temp = cur;
			cur = pre;
			pre = temp;
		}
		System.out.println("YES");
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
