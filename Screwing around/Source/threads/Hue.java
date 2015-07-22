package threads;
import java.lang.Runnable;
import java.util.ArrayList;

public class Hue implements Runnable{

	ArrayList<String> str;
	
	public Hue(){
		str = new ArrayList<String>();
	}
	public void run() {
		// TODO Auto-generated method stub
		for(int x = 0; x<100; x++){
			str.add(x+"");
			System.out.println(str.get(x));
		}
	}

	
	
}
