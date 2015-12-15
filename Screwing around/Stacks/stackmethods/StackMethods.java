package stackmethods;
import java.util.Stack;

public class StackMethods {

    public static void main(String[] args){
        Stack<Integer> a = new Stack<Integer>();

        a.push(5);

        a.push(2);

        a.push(7);

        System.out.println(getAverage(a));
        
        Stack<String> b = new Stack<String>();

        b.push("one");

        b.push("two");

        Stack<String> c = new Stack<String>();

        c.push("three");

        c.push("four");

        c.push("five");

        display(alternateStack(b,c));

        System.out.println();

        Stack<String> d = new Stack<String>();

        d.push("six");

        d.push("seven");

        d.push("eight");

        d.push("nine");

        d.push("ten");

        display(removeEveryOther(d));
    }
    
    public static double getAverage(Stack<Integer> one){
        int total = 0;
        int counter = 0;
        while(! one.isEmpty()){
            counter++;
            total+=one.pop();
        }
        
        return (double)total/counter;
    }

    public static Stack<String> alternateStack (Stack<String>  one, Stack<String> two){
        Stack<String> temp1 = new Stack();
        while(! one.isEmpty()){
            temp1.push(one.pop());
        }
        one = temp1;
        
        Stack<String> temp2 = new Stack();
        while(! two.isEmpty()){
            temp2.push(two.pop());
        }
        two = temp2;
        
        
        Stack<String> toRet = new Stack<String>();
        
        int turn = 1;
        while(! (one.isEmpty()) && ! (two.isEmpty())){
            if(turn ==1){
                toRet.push(one.pop());
                turn = 2;
            }
            
            else{
                toRet.push(two.pop());
                turn = 1;
            }
        }
        
        while(! one.isEmpty()){
            toRet.push(one.pop());
        }
        
        while(! two.isEmpty()){
            toRet.push(two.pop());
        }
        
        return toRet;
    }

            //Good Question: For alternating stacks, are they the same size??…Do they have to be???

    public static Stack<String> removeEveryOther(Stack<String> one){
        Stack<String> toRet = new Stack<String>();
        
        int turn = 1;
        while(! one.isEmpty()){
            if(turn == 1){
                toRet.push(one.pop());
                turn = 2;
            }
            
            else{
                one.pop();
                turn = 1;
            }
        }

        return toRet;
    }

          //Removes every other element in the stack – but the order of others shouldn’t change.

    public static void display(Stack<String> one){
        while(! one.isEmpty()){
            System.out.println(one.pop());
        }
    }

          //We want to print in the order that it comes off the stack
    
}


