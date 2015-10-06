package towersOfHanoi;

public class TowersOfHanoi {

	public static void main(String[] args){
		System.out.println(hanoi(5));
	}

	public static int hanoi(int disks){
		if(disks == 1){
			return 1;
		}
		
		return 2*hanoi(disks-1);
		
		
	}

}
