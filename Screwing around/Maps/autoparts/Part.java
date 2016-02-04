package autoparts;

public class Part implements Comparable<Part>
{
	private String make, model, rest;
	private int year;

	public Part(String line) 
	{
		String[] list = line.split(" ");

		make = list[0];
		model = list[1];
		year = Integer.parseInt(list[2]);
		
		rest = "";
		for(int x = 3; x<list.length; x++){
			rest+=list[x] + " ";
		}
		
	}

	public int compareTo( Part rhs )
	{
		return toString().compareTo(rhs.toString());
	}

	public String getMake(){
		return make;
	}
	
	public String getModel(){
		return model;
	}
	
	public int getYear(){
		return year;
	}
	
	public String getRest(){
		return rest;
	}
	
	public String toString()
	{
		return make+ " " + model+ " " + year+ " " + rest;
	}
}