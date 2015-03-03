import java.util.*;
import java.io.*;

public class P492E2 {

	private static void solve() {
		int n = nextInt();
		int m = nextInt();
		int dx = nextInt();
		int dy = nextInt();

		int[] modMap = new int[n];
		int modDx = 0;
		for (int i = 0; i < n; i++) {
			modMap[modDx] = i;
			// => (dx * modMap[k]) % n = k
			modDx += dx;
			if (modDx >= n) {
				modDx -= n;
			}
		}
		int[][] xyMap = new int[n][3];
		for (int i = 0; i < m; i++) {
			int x = nextInt();
			int y = nextInt();
			int k = modMap[x > 0 ? n - x : 0];
			k = (int) ((y + (long) k * dy) % n);
			xyMap[k][2]++;
			xyMap[k][0] = x;
			xyMap[k][1] = y;
		}

		int max = 0;
		int maxIndex = -1;
		for (int i = 0; i < n; i++) {
			if (xyMap[i][2] > max) {
				max = xyMap[i][2];
				maxIndex = i;
			}
		}
		System.out.println(max + " " + xyMap[maxIndex][0] + " " + xyMap[maxIndex][1]);
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