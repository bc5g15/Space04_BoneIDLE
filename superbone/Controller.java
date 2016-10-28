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
	
}
