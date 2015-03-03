import java.util.*;
import java.io.*;

public class P490C {

	private static void solve() {
		String d = next();
		int a = nextInt();
		int b = nextInt();

		int len = d.length();
		int ma = 0;
		int[] mas = new int[len];
		for (int i = 0; i < len; i++) {
			ma = (ma * 10 + d.charAt(i) - '0') % a;
			mas[i] = ma;
		}

		int mod10b = 1;
		int mb = 0;
		for (int i = 1; i < len; i++) {
			char di = d.charAt(len - i);
			if (di > '0') {
				mb = (mb + mod10b * (di - '0')) % b;
				if (mb == 0 && mas[len - i - 1] == 0) {
					System.out.println("YES");
					System.out.println(d.substring(0, len - i));
					System.out.println(d.substring(len - i, len));
					return;
				}
			}
			mod10b = (mod10b * 10) % b;
		}
		System.out.println("NO");
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