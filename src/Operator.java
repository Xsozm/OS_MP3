import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Operator {
	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		FastScanner sc = new FastScanner("input-2.txt");
		PrintWriter out = new PrintWriter("ouroutput-2.txt");
		StringBuilder sb = new StringBuilder();
		int max_wait_time = sc.nextInt();
		int n = sc.nextInt();
		Player[] P = new Player[n];
		for (int i = 0; i < n; i++) {
			String str = sc.nextToken();
			int x = Integer.parseInt(str.split(",")[0]);
			int y = Integer.parseInt(str.split(",")[1]);

			P[i] = new Player(x, y);
			P[i].out = out;
			P[i].sb = sb;
		}
//		Arrays.sort(P);
		Wheel wh = new Wheel(max_wait_time);
		wh.count = n;
		wh.out = out;
		wh.sb = sb;
		wh.start();
		for (Player p : P) {
			p.wh = wh;
			p.start();
		}

	}

}

class FastScanner {

	BufferedReader br;
	StringTokenizer st;

	public FastScanner() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	public FastScanner(String s) {
		try {
			br = new BufferedReader(new FileReader(s));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	String nextToken() {
		while (st == null || !st.hasMoreElements()) {
			try {

				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(nextToken());
	}

	long nextLong() {
		return Long.parseLong(nextToken());
	}

	double nextDouble() {
		return Double.parseDouble(nextToken());
	}

}
