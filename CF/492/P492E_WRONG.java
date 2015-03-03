import java.util.*;
import java.io.*;

public class P492E_WRONG {

	private static void solve() {
		long n = nextInt();
		int m = nextInt();
		long dx = nextInt();
		long dy = nextInt();

		// Line (x0 + tdx, y0 + tdy) intersect Oy at (0, y0 - x0/dx * dy) (t = -x0/dx)
		// (0, ux) and (0, ux + k*n) are in the same path

		long[][] xyr = new long[m][3];
		long modXY = n * (dx < dy ? dx : dy); // 10^12
		for (int i = 0; i < m; i++) {
			long x = nextInt();
			long y = nextInt();
			xyr[i][0] = x;
			xyr[i][1] = y;
			long r = (dx < dy ? 1 : -1) * (dx * y - dy * x);
			r %= modXY;
			if (r < 0) {
				r += modXY;
			}
			xyr[i][2] = r;
		}

		Arrays.sort(xyr, new Comparator<long[]>() {
			public int compare(long[] s, long[] t) {
				if (s[2] > t[2]) {
					return 1;
				}
				if (s[2] < t[2]) {
					return -1;
				}
				return 0;
			}
		});
		int max = 0;
		int maxIndex = -1;
		int count = 1;
		for (int i = 0; i < m; i++) {
			long[] p0 = xyr[i];
			long[] p1 = i < m - 1 ? xyr[i + 1] : new long[] { -1, -1, -1 };
			if (p0[2] == p1[2]) {
				count++;
			}
			else {
				if (count > max) {
					max = count;
					maxIndex = i;
				}
				count = 1;
			}
		}
		System.out.println(max + " " + xyr[maxIndex][0] + " " + xyr[maxIndex][1]);
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

// Arrays.sort(xy, new Comparator<int[]>() {
// public int compare(int[] s, int[] t) {
// if (s[0] != t[0]) {
// return s[0] - t[0];
// }
// return s[1] - t[1];
// }
// });