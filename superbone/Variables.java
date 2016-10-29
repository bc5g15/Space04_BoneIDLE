package superbone;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * A static class designed to handle variables for the BareBones implementation
 */
public class Variables {
	private static HashMap<String, Integer> vars = new HashMap<String, Integer>();
	
	//Implement the clear instruction
	//This also declares the variable
	public static void clrVar(String name)
	{
		vars.put(name, 0);
	}
	
	//Implement the increment instruction
	public static void incVar(String name)
	{
		if(vars.containsKey(name))
		{
			int i = vars.get(name);
			i++;
			vars.put(name, i);
		}
		else System.out.println("Unknown variable referenced! Ignoring Instruction.");
	}
	
	//Implement the decrement instruction
	public static void decVar(String name)
	{
		if(vars.containsKey(name))
		{
			int i = vars.get(name);
			i--;
			vars.put(name, i);
		}
		else
		{
			System.out.println("Unknown variable referenced! Ignoring Instruction.");
		}
	}
	
	//Return a variable value;
	public static int GetVal(String name)
	{
		if(vars.containsKey(name)) return vars.get(name);
		else
		{
			System.out.println("Unknown variable referenced! Returning default value 0");
			return 0;
		}
	}
	
	//Prints out the variables in a nicely formatted way.
	public static void PrintVars()
	{
		Iterator<Map.Entry<String, Integer>> data = vars.entrySet().iterator();
		
		System.out.println("Variables:");
		
		while(data.hasNext())
		{
			Map.Entry<String, Integer> entry = data.next();
			System.out.printf("Name: %s\tValue: %d\n", entry.getKey(), entry.getValue());
		}
	}
	
	public static String GetAllVars()
	{
		Iterator<Map.Entry<String, Integer>> data = vars.entrySet().iterator();
		String output = "Variables:\n";
		
		while(data.hasNext())
		{
			Map.Entry<String, Integer> entry = data.next();
			String name = entry.getKey();
			String value = entry.getValue().toString();
			output += name + "\t" + value + "\n";
		}
		
		return output;
	}
	
	public static void Clear()
	{
		vars.clear();
	}
	
}
