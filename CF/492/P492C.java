import java.util.*;
import java.io.*;

public class P492C {

	private static void solve() {
		int n = nextInt();
		int r = nextInt();
		int avg = nextInt();
		long totalNeed = (long) n * avg;

		int[][] subjects = new int[n][2];
		for (int i = 0; i < n; i++) {
			int grade = nextInt();
			subjects[i][0] = grade;
			subjects[i][1] = nextInt();
			totalNeed -= grade;
		}

		Arrays.sort(subjects, new Comparator<int[]>() {
			public int compare(int[] s, int[] t) {
				return s[1] - t[1];
			}
		});

		long sum = 0;
		for (int i = 0; i < n; i++) {
			if (totalNeed > 0) {
				long need = Math.min(totalNeed, r - subjects[i][0]);
				totalNeed -= need;
				sum += need * subjects[i][1];
			}
		}
		System.out.println(sum);
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