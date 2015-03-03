import java.util.*;
import java.io.*;

public class P490D {

	private static void solve() {
		int a1 = nextInt();
		int b1 = nextInt();
		int c1 = nextInt();
		int d1 = nextInt();

		a1 = factorize23(a1);
		int a3 = f3;
		int a2 = f2;

		b1 = factorize23(b1);
		int b3 = f3;
		int b2 = f2;

		c1 = factorize23(c1);
		int c3 = f3;
		int c2 = f2;

		d1 = factorize23(d1);
		int d3 = f3;
		int d2 = f2;

		if (a1 * b1 == c1 * d1) {

			int rt = Math.abs(a3 + b3 - c3 - d3);
			if (a3 + b3 > c3 + d3) {
				a2 += Math.min(a3, rt);
				b2 += Math.max(0, rt - a3);
				b3 -= Math.max(0, rt - a3);
				a3 -= Math.min(a3, rt);
			}
			else {
				c2 += Math.min(c3, rt);
				d2 += Math.max(0, rt - c3);
				d3 -= Math.max(0, rt - c3);
				c3 -= Math.min(c3, rt);
			}

			int rs = Math.abs(a2 + b2 - c2 - d2);
			if (a2 + b2 > c2 + d2) {
				b2 -= Math.max(0, rs - a2);
				a2 -= Math.min(a2, rs);
			}
			else {
				d2 -= Math.max(0, rs - c2);
				c2 -= Math.min(c2, rs);
			}

			System.out.println(rt + rs);
			a1 = (int) (a1 * Math.pow(2, a2) * Math.pow(3, a3));
			b1 = (int) (b1 * Math.pow(2, b2) * Math.pow(3, b3));
			c1 = (int) (c1 * Math.pow(2, c2) * Math.pow(3, c3));
			d1 = (int) (d1 * Math.pow(2, d2) * Math.pow(3, d3));
			System.out.println(a1 + " " + b1);
			System.out.println(c1 + " " + d1);

		}
		else {
			System.out.println(-1);
		}
	}

	static int f2 = 0;
	static int f3 = 0;

	private static int factorize23(int a) {
		f2 = 0;
		f3 = 0;
		int d = 3;
		while (a % d == 0) {
			a /= d;
			f3++;
		}
		d = 2;
		while (a % d == 0) {
			a /= d;
			f2++;
		}
		return a;
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