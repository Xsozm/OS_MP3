
public class Player extends Thread implements Comparable {
	
	public int ID;
	public int waiting_time;
	public boolean on_board=false;
	public boolean ride_complete=false;
	Wheel wh ;
	
	public Player(int id , int time) {
		ID=id;
		waiting_time=time;
		
	}
	
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getWaiting_time() {
		return waiting_time;
	}

	public void setWaiting_time(int waiting_time) {
		this.waiting_time = waiting_time;
	}

	public boolean isOn_board() {
		return on_board;
	}

	public void setOn_board(boolean on_board) {
		this.on_board = on_board;
	}

	public boolean isRide_complete() {
		return ride_complete;
	}

	public void setRide_complete(boolean ride_complete) {
		this.ride_complete = ride_complete;
	}
	
	State state(){
		return this.getState();
	}
	

	@SuppressWarnings("static-access")
	public void run(){
		try {
			this.sleep(waiting_time);
			System.out.println("player wakes up: "+(getID()));
			wh.load_players(this);


		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//System.out.println("Inte");
			//e.printStackTrace();
		}
		
		//System.out.println(this.getState());
		

	}


	@Override
	public int compareTo(Object o) {
		return this.waiting_time-((Player)o).waiting_time;
	}  

}
