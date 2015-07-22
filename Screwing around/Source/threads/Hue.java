package threads;
import java.lang.Runnable;
import java.util.ArrayList;

public class Hue implements Runnable{

	private Thread t;
	private String threadName;
	ArrayList<String> str;

	public Hue(String name){
		threadName = name;
		str = new ArrayList<String>();
	}

	public void start(){
		if (t == null)
		{
			t = new Thread (this, threadName);
			t.start ();
		}
	}

	public void run() {
		// TODO Auto-generated method stub
		for(int x = 0; x<100; x++){
			str.add(x+"");
			System.out.println(str.get(x));
		}
	}



}
