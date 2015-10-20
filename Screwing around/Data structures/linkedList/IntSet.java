package linkedList;

public class IntSet {

	public int x;
	public int y;

	public IntSet(int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX(){
		return x;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public String toString(){
		if(x != 0){
			if(y > 1 || (y > 0 && y < 1) || y < 0)
				return x+"x^"+y;
			else if(y==1)
				return x+"x";
			else if(y==0)
				return x+"";
		}
		return 0+"";
	}
	
}
