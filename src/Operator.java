import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Operator {
	public static void main(String[] args) throws InterruptedException {
		FastScanner sc = new FastScanner("input-2.txt");
	    PrintWriter out = new PrintWriter(System.out);
	    int max_wait_time = sc.nextInt();
	    int n =sc.nextInt();
	    Player[]P = new Player[n];
	    boolean vis[]=new boolean[n];
	    int k =0 ;
	    for(int i=0;i<n;i++) {
	    	k++;
	    	String str = sc.nextToken();
	    	int x = Integer.parseInt(str.split(",")[0]);
	    	int y = Integer.parseInt(str.split(",")[1]);

	    	P[i]=new Player(x, y);
	    	
	    	
	    	
	    }
	    Arrays.sort(P);
	    Wheel wh = new Wheel(max_wait_time);
	    wh.start();
	    for(Player p :P) {
	    	p.wh=wh;
	    	p.start();
	    }
	   
	   
	   /* boolean f= true;
	    while(f){
	    	for(int i=0;i<P.length;i++) {
	    		if(P[i].state()==Thread.State.TERMINATED && P[i].isRide_complete()==false && !vis[i]) {

	    			wh.load_players(P[i]);
	    			vis[i]=true;
	    		}

	    	}
	    	int c = 0;
	    	for(int j=0;j<vis.length;j++)
	    		if(vis[j])c++;
	    	if(c==n && wh.list_of_currently_on_board_player.size()==0) {
	    		wh.suspend();
	    		for(Player p :P)
	    	    	p.suspend();
	    	}
	    	

	    }*/
	    
	    
	    
		
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
