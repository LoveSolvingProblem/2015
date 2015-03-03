import java.util.*;
import java.io.*;

public class P488C {

	private static void solve() {
		int HY = nextInt(), AY = nextInt(), DY = nextInt();
		int HM = nextInt(), AM = nextInt(), DM = nextInt();
		int h = nextInt(), a = nextInt(), d = nextInt();

		int baseCost = Math.max(DM + 1 - AY, 0) * a;
		AY = Math.max(AY, DM + 1);

		int minCost = Integer.MAX_VALUE;
		int hasMin = 0;
		int dCost = 0;
		for (int dy = DY; dy < AM; dy++) {
			int aCost = 0;
			for (int ay = AY; ay < 201; ay++) {
				int hCost = Math.max((HM + ay - DM - 1) / (ay - DM) * (AM - dy) + 1 - HY, 0) * h;
				minCost = Math.min(minCost, dCost + aCost + hCost);
				hasMin = 1;
				aCost += a;
			}
			dCost += d;
		}
		if (DY < AM) {
			minCost = Math.min(minCost, (AM - DY) * d);
		}
		System.out.println(baseCost + minCost * hasMin);
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