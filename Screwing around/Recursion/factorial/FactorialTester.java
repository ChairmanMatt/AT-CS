package factorial;

public class FactorialTester {

	public static void main(String[] args){
		System.out.println(reverse("Chris"));
		
	}
	
	public static int factorialIterative (int num){
		int ret = 1;
		for(int x = num; x>0; x--){
			ret*=x;
		}
		return ret;
	}

	public static int factorialRecursive (int num){
		if(num==1)
			return 1;
		
		return num*factorialRecursive(num-1);
	}
	
	public static int fibonacci(int num){
		if(num<=2)
			return 1;
		
		return fibonacci(num-1)+fibonacci(num-2);
		
	}
	
	public static String reverse(String s){
		return reverse(s, "");
	}
	
	public static String reverse(String s, String n){
		if(s.length()==0)
			return n;
		
		return reverse(s.substring(1), s.substring(0,1)+n);
	}
	
}
