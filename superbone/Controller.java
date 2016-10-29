package superbone;

import java.util.Stack;

/*
 * This class controls the execution of instruction sets
 */
public class Controller
{
	static Stack<InstructionSet> current = new Stack<InstructionSet>();
	static int instCount = 0;
	
	public static void Clear()
	{
		instCount = 0;
		current.clear();
		Variables.Clear();
	}
	
	public static void AddSet(InstructionSet is)
	{
		current.push(is);
	}
	
	public static void RemoveSet()
	{
		current.pop();
	}
	
	public static void next()
	{
		current.peek().next();
		instCount += 1;
	}
	
	public static boolean hasNext()
	{
		if(current.size() > 1)
		{
			return true;
		}
		else
		{
			return current.peek().hasNext();
		}
	}
	
	public static void FullRun()
	{
		while(hasNext())
		{
			next();
		}
	}
	
	public static int getInstructionNumber()
	{
		return instCount;
	}
	
	public static void adjustInstructionNumber(int value)
	{
		instCount += value;
	}
	
	/*
	 * Used by the REPL interpreter.
	 */
	public static void handleSimpleInstruction(String inst)
	{
		//"Simple" defined as "Not affecting control flow"
		String s = inst.replace(";", "");
		Reader.interpretBasic(s).execute();
	}
	
}
