import java.util.concurrent.Semaphore;

public class Barrier{
	
	// add missing variables
	public int counter;
	public int number;
	public Semaphore mutex;
	public Semaphore barrier;

	
	Barrier(int n) {
		// complete this constructor
		//counter = 0;
		this.number = n;
		barrier = new Semaphore(0);
		mutex =  new Semaphore(1);
	}
	
	public void b_wait() throws InterruptedException{
		// this is the only additional method you will need to complete
		try {mutex.acquire();}
		catch(InterruptedException e){throw new RuntimeException("Couldn't aquire mutex", e);}
		counter++;
		mutex.release();
		
		if(counter == number){
			barrier.release(); //tells threads to continue to what process they are doing
		}
		/*This is a turnstile that allows on thread to pass at a time*/
		try{barrier.acquire();
		barrier.release();}
		catch(InterruptedException e){e.printStackTrace();}
	}

}
