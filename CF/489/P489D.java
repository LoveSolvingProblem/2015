import java.util.*;
import java.io.*;

public class P489D {

	private static void solve() {
		int n = nextInt();
		int m = nextInt();
		ArrayList<ArrayList<Integer>> parrents = new ArrayList<ArrayList<Integer>>();
		ArrayList<int[]> grands = new ArrayList<int[]>();

		for (int i = 0; i < n; i++) {
			parrents.add(new ArrayList<Integer>());
			grands.add(new int[n]);
		}

		for (int i = 0; i < m; i++) {
			int s = nextInt() - 1;
			int t = nextInt() - 1;
			parrents.get(t).add(s);
		}

		long sum = 0;
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> pi = parrents.get(i);
			int leni = pi.size();
			int[] grandi = grands.get(i);
			for (int j = 0; j < leni; j++) {
				ArrayList<Integer> pj = parrents.get(pi.get(j));
				int lenj = pj.size();
				for (int k = 0; k < lenj; k++) {
					if (i != pj.get(k)) {
						sum += (grandi[pj.get(k)]++);
					}
				}
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

	public static void main(String[] args) {
		run();
	}
}