package superbone;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * This class reads in text instructions and converts them into
 * the relevant objects
 */
public class Reader {
	
	//static Stack<Executable> loops = new Stack<Executable>();
	
	//This mainly just populates the Controller thing.
	public static void readBigFile(String fileText)
	{
		Stack<InstructionSet> current = new Stack<InstructionSet>();
		
		//Add the base instruction set
		InstructionSet base = new InstructionSet();
		current.push(base);
		//This is all I need to add it to the controller
		Controller.Clear();
		Controller.AddSet(base);
		
		//Split the file into individual instructions
		//Then run those through an interpreter.
		String[] codes = fileText.toLowerCase().split(";");
		for(String item : codes)
		{
			//Blank instructions are ignored
			if(!item.isEmpty())
			{
				StringTokenizer st = new StringTokenizer(item);
				//Feed it into the interpreter and populate my InstructionSet
				//String[] temp = item.split(" ");
				String temp = st.nextToken();
				if(temp.equals("while"))
				{
					Conditional c = new VarNotZero(st.nextToken());
					InstructionSet i = new InstructionSet(c);
					//Cheat. Here I should really evaluate the condition.
					EnterLoop e = new EnterLoop(i, c);
					current.peek().AddInstruction(e);
					current.push(i);
					
				}
				else if(temp.equals("end"))
				{
					//No real exit-loop command. Just stop writing into it.
					if(current.size()>1) current.pop();
					else System.out.println("Bad! Trying to exit the main loop!");
					
				}
				else
				{
					current.peek().AddInstruction(interpretBasic(item));
				}
			}
		}
	}

	public static void BuildInstructionSet(String codeIn)
	{
		//Lets test the 
		
	}
	
	public static Executable interpretBasic(String text)
	{
		
		String[] code = new String[2];
		StringTokenizer temp = new StringTokenizer(text);
		code[0] = temp.nextToken();
		if(temp.hasMoreTokens()) code[1] = temp.nextToken();
		
		
		//I'm sure there is a better way of doing this.
		if(code[0].equals("clear"))
		{
			return new Clear(code[1]);
		}
		else if(code[0].equals("incr"))
		{
			return new Increment(code[1]);
		}
		else if(code[0].equals("decr"))
		{
			return new Decrement(code[1]);
		}
		else return new Pass();
	}
	
	

}
