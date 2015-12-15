package cards;

public class Card implements Comparable{

	private int suit;
	private int value;

	public Card(){
		value = 3;
		suit = 1;
	}

	public Card(int suit, int value){
		this.value = value;
		this.suit = suit;
	}

	public String getValue(){
		if(value <= 10)
			return value+"";
		if(value == 11)
			return "J";
		if(value == 12)
			return "Q";
		if(value == 13)
			return "K";

		return "A";
	}

	private static int intValue(String strVal){
		if(strVal.equals("A"))
			return 14;
		if(strVal.equals("K"))
			return 13;
		if(strVal.equals("Q"))
			return 12;
		if(strVal.equals("J"))
			return 11;

		return Integer.parseInt(strVal);
	}

	public String getSuit(){
		if(suit == 1)
			return "Clubs";
		if(suit == 2)
			return "Diamonds";
		if(suit == 3)
			return "Hearts";

		return "Spades";
	}

	public String toString(){
		return (getValue()+" of "+getSuit());
	}

	public int compareTo(Object cred) {
		if(getSuit().equals(((Card) cred).getSuit())){
			if(intValue(((Card) cred).getValue()) == intValue(getValue()))
				return 0;
			if(intValue(((Card) cred).getValue()) > intValue(getValue()))
				return -1;
			
			return 1;
		}
	}


}
