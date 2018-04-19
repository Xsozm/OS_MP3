import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Operator {
	public static void main(String[] args) {
		FastScanner sc = new FastScanner("input-1.txt");
	    PrintWriter out = new PrintWriter(System.out);
	    int max_wait_time = sc.nextInt();
	    int n =sc.nextInt();
	    Player[]P = new Player[n];
	    for(int i=0;i<n;i++) {
	    	P[i]=new Player(sc.nextInt(), sc.nextInt());
	    	
	    }
	    Wheel wh = new Wheel(max_wait_time);
	    
	    
		
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
