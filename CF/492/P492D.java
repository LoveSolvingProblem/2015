import java.util.*;
import java.io.*;

public class P492D {

	private static void solve() {
		long n = nextInt();
		long x = nextInt();
		long y = nextInt();

		// a.ix <= (ai-a).iy < (a+1).ix => Vanya (ix = 1/x)
		// a.iy <= (ai-a).ix < (a+1).iy => Vova (iy = 1/y)

		StringBuffer bf = new StringBuffer();
		for (int i = 0; i < n; i++) {
			long ai = nextInt();
			double da = ai * x / (x + y);
			if ((ai * x) % (x + y) == 0 || ((ai + 1) * x) % (x + y) == 0) {
				bf.append("Both\r\n");
				continue;
			}
			int a = (int) da;
			if ((double) (ai - a) / y < (double) (a + 1) / x) {
				bf.append("Vova\r\n");
				continue;
			}
			bf.append("Vanya\r\n");
		}

		System.out.println(bf.toString());
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