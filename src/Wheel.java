import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.io.PrintWriter;
import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.Collections;

public class Wheel extends Thread {
	int capacity = 5;
	int count_of_currently_on_board_players;
	List<Player> list_of_currently_on_board_player = Collections.synchronizedList((new ArrayList<Player>()));
	int maximum_waiting_time;
	int count;
	PrintWriter out;

	public Wheel(int x) {

		this.maximum_waiting_time = x;

	}

	public int getCount_of_currently_on_board_players() {
		return count_of_currently_on_board_players;
	}

	public void setCount_of_currently_on_board_players(int count_of_currently_on_board_players) {
		this.count_of_currently_on_board_players = count_of_currently_on_board_players;
	}

	public List<Player> getList_of_currently_on_board_player() {
		return list_of_currently_on_board_player;
	}

	public void setList_of_currently_on_board_player(ArrayList<Player> list_of_currently_on_board_player) {
		this.list_of_currently_on_board_player = list_of_currently_on_board_player;
	}

	public int getMaximum_waiting_time() {
		return maximum_waiting_time;
	}

	public void setMaximum_waiting_time(int maximum_waiting_time) {
		this.maximum_waiting_time = maximum_waiting_time;
	}

	public synchronized void load_players(Player p) {
		out.println("passing player: " + (p.getID()) + " to the operator\n\n" + "Player " + (p.getID())
				+ " on board, capacity: " + (list_of_currently_on_board_player.size() + 1) + "\n");
		list_of_currently_on_board_player.add(p);
		// out.println(list_of_currently_on_board_player.size());
		p.setOn_board(true);
		count--;
		this.setCount_of_currently_on_board_players(this.getCount_of_currently_on_board_players() + 1);
		if (IsFull() && this.getState() == Thread.State.TIMED_WAITING) {
			this.interrupt();
		}
	}

	public void run_ride() {

	}

	public void end_ride() {
		count_of_currently_on_board_players = 0;
		for (Player p : this.list_of_currently_on_board_player) {
			p.setRide_complete(true);
			p.setOn_board(false);
		}
		list_of_currently_on_board_player.clear();
	}

	public boolean IsFull() {
		return capacity == list_of_currently_on_board_player.size();
	}

	State state() {
		return this.getState();
	}

	public void run() {

		while (count > 0) {

			out.println("wheel start sleep\n");

			try {
				Thread.sleep(maximum_waiting_time);
				out.println("Wheel end sleep\n");
				out.println("Wheel is full, Let's go for a ride\n");
				run_ride();
				end_ride();

			} catch (InterruptedException e) {
				out.println("Wheel is full, Let's go for a ride \n\nThreads in this ride are:\n");
				for (int i = 0; i < this.list_of_currently_on_board_player.size(); i++)
					out.print(this.list_of_currently_on_board_player.get(i).getID() + " ");
				out.println("\n");
				run_ride();
				end_ride();
				// e.printStackTrace();
				// out.println("Interrupted !");
			}

		}
		out.flush();
	}
}
