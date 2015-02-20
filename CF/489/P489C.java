import java.util.*;
import java.io.*;

public class P489C {

	private static void solve() {
		int m = nextInt();
		int s = nextInt();

		// 99T000
		// 10T999
		int M9 = s / 9;
		int T = s % 9;
		int MT = T > 0 ? 1 : 0;

		if (M9 + MT <= m && M9 + MT > 0) {
			char[] digits = new char[m];
			Arrays.fill(digits, 0, M9, '9');
			Arrays.fill(digits, M9, M9 + MT, (char) (T + '0'));
			Arrays.fill(digits, M9 + MT, m, '0');
			String max = new String(digits);

			if (M9 + 1 < m) {
				if (T > 0) {
					digits[m - 1] = '1';
					digits[M9]--;
				}
				else {
					digits[m - 1] = '1';
					digits[M9 - 1]--;
				}
			}
			int len = m;
			for (int i = 0; i < m / 2; i++) {
				char temp = digits[i];
				digits[i] = digits[m - 1 - i];
				digits[m - 1 - i] = temp;
			}
			String min = new String(digits);
			System.out.println(min + " " + max);
		}
		else if (m == 1 && s == 0) {
			System.out.println("0 0");
		}
		else {
			System.out.println("-1 -1");
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

	public static void main(String[] args) {
		run();
	}
}