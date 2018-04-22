
public class test extends Thread {
	int x= 0 ;
	void f() {
		while(true) {
			if(x==1) {
				this.interrupt();
				 break;
			}
		}
	}
	public static void main(String[] args) {
		test t =new test();
		t.start();
		t.x=1;
		t.f();
		
	}
	@Override
	public void run() {
		try {
			Thread.sleep(10000000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("III");
			//e.printStackTrace();
		}
	}
}
