package calc;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.Optional;
import java.util.Scanner;
import java.util.Stack;
import java.util.function.BiFunction;

public class ShittyCalculatorWithParentheses {
	private static final DecimalFormat ints=new DecimalFormat("# ### ##0.#######;-#");
	
	private final Double answer;
	private final String input;
	private final Stack<Operator> operators;
	private final Stack<String> output, tokens;

	/**
	 * Takes a string of characters separated by spaces, and mathematically evaluates it.
	 * @param input String containing the expression to evaluate, where each character is delimited by spaces.
	 */
	public ShittyCalculatorWithParentheses(String input) {
		this.input=input;
		operators=new Stack<Operator>();
		output=new Stack<String>();
		tokens=new Stack<String>();
		tokens.addAll(Arrays.asList(input.split(" ")));
		Collections.reverse(tokens);
		shunt();
		answer=eval();
	}
	
	/**
	 * Prints the answer of the expression given.
	 */
	public void printAnswer() {
		if(null==answer) System.out.println("No answer...");
		else System.out.println(ints.format(answer)+"\n");
	}
	
	/**
	 * Evaluates the expression.
	 * @return The value found after evaluating the given RPN statement.
	 */
	private Double eval() {
		output.forEach(x->System.out.print(x+" "));
		System.out.print("\n\t");
		
		tokens.addAll(output);
		Collections.reverse(tokens);
		output.clear();

		while(!tokens.isEmpty()) {
			final String token=tokens.pop();
			if(token.matches("-?[0-9]+(\\.[0-9]*)?")) output.push(token);
			else { // assumes that all functions and operators take 2 numbers only.
				final double b=Double.parseDouble(output.pop()), a=Double.parseDouble(output.pop());
				output.push(Operator.valueOf(Arrays.stream(Operator.values()).filter(x->x.toString().equals(token)).findFirst().get().name()).evaluate(a,b).get().toString());
			}
		}
		if(output.size()!=1) {
			System.err.println("Mismatched values...\t"+input);
			return null;
		}
		return Double.parseDouble(output.peek());
	}
	/**
	 * Shunts the expression into RPN, using Dijkstra's Shunting-Yard Algorithm.
	 * The code follows the exact specifications of the Wikipedia article on the S-Y Algorithm.
	 */
	private void shunt() {
		while(!tokens.isEmpty()) {
			final String token=tokens.pop();
			if(token.matches("-?[0-9]+(\\.[0-9]*)?")) output.push(token);
			else if(Arrays.stream(Operator.values()).filter(x->x.associativity()!=Operator.Associativity.NONE).map(Operator::toString).anyMatch(z->z.equals(token))) {
				final Operator op=Operator.valueOf(Arrays.stream(Operator.values()).filter(x->x.toString().equals(token)).findFirst().get().name());
				while(!operators.isEmpty()&&((op.associativity()==Operator.Associativity.LEFT&&op.precedence()<=operators.peek().precedence())||(op.associativity()==Operator.Associativity.RIGHT&&op.precedence()<operators.peek().precedence())))
					output.push(operators.pop().toString());
				operators.push(op);
			} else if(token.equals("(")) {
				operators.push(Operator.LEFT_PAREN);
			} else if(token.equals(")")) {
				try {
					while(operators.peek()!=Operator.LEFT_PAREN)
						output.push(operators.pop().toString());
					operators.pop();
				} catch(EmptyStackException ese) {
					System.err.println("Parentheses mismatch...\t"+input);
				}
			}
					
		}
		while(!operators.isEmpty())
			output.push(operators.pop().toString());
	}
	
	public static void main(String[] args) {
//		new ShittyCalculator("3 + 4").printAnswer(); // 3 4 +	7
//		new ShittyCalculator("1 + 2 * 3 - 4").printAnswer(); // 1 2 3 * + 4 -	3
//		new ShittyCalculator("3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3").printAnswer(); // 3 4 2 * 1 5 - 2 3 ^ ^ / +	3.0001220703125
//		new ShittyCalculator("5 + ( ( 1 + 2 ) * 4 ) - 3").printAnswer(); // 5 1 2 + 4 * + 3 -	14
//		new ShittyCalculator("( 3 + 2 * 4 ^ 2 ) / -5").printAnswer();
		final Scanner in=new Scanner(System.in);
		
		System.out.println("Welcome to Matts' shitty calculator.\n");
		while(true) {
			System.out.println("Calculate this:");
			new ShittyCalculatorWithParentheses(in.nextLine()).printAnswer();
		}
	}
	
	private enum Operator {
		DIV(Associativity.LEFT, (a,b)->a/b, "/", 2), EXP(Associativity.RIGHT, (a,b)->Math.pow(a, b), "^", 3), LEFT_PAREN(Associativity.NONE, null, "(", 0), MINUS(Associativity.LEFT, (a,b)->a-b, "-", 1),  MULT(Associativity.LEFT, (a,b)->a*b, "*", 2), PLUS(Associativity.LEFT, (a,b)->a+b, "+", 1), RIGHT_PAREN(Associativity.NONE, null, ")", 0);
		
		private final Associativity assoc;
		private final BiFunction<Double, Double, Double> function;
		private final String name;
		private final int precedence;
		
		private Operator(Associativity assoc, BiFunction<Double, Double, Double> function, String name, int precedence) {
			this.assoc=assoc;
			this.function=assoc!=Associativity.NONE?function:(a,b)->null;
			this.name=name;
			this.precedence=precedence;
		}
		
		public Associativity associativity() {
			return assoc;
		}
		public Optional<Double> evaluate(double x, double y) {
			return Optional.ofNullable(function.apply(x, y));
		}
		public int precedence() {
			return precedence;
		}
		@Override
		public String toString() {
			return name;
		}
		
		private enum Associativity {
			LEFT, NONE, RIGHT;
		}
	}
}