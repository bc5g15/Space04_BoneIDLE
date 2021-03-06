package superbone;
import java.util.ArrayList;
import java.util.Iterator;

//Holds lists of instructions, with some provisions for loops
public class InstructionSet {
	private ArrayList<Executable> inst;
	private Iterator<Executable> it = null;
	private Conditional c;
	private int instStart;
	
	public InstructionSet()
	{
		inst = new ArrayList<Executable>();
		//it = inst.iterator();
		c = null;
		instStart = 0;
	}
	
	public InstructionSet(Conditional c, int startpoint)
	{
		inst = new ArrayList<Executable>();
		//it = inst.iterator();
		this.c = c;
		instStart = startpoint;
	}
	
	
	private void buildIterator()
	{
		if(it == null)
		{
			it = inst.iterator();
		}
		
	}
	
	public boolean hasNext()
	{
		buildIterator();
		return it.hasNext();
	}
	
	public void next()
	{
		buildIterator();
		if(it.hasNext())
		{
			it.next().execute();
		}
		else
		{
			//If a loop, check conditional code.
			//Otherwise, program just ends.
			CheckEnd();
		}
	}
	
	public void AddInstruction(Executable ex)
	{
		inst.add(ex);
	}
	
	private void CheckEnd()
	{
		if(!(c == null))
		{
			if(c.Evaluate())
			{
				//If true. Loop again.
				it = inst.iterator();
				//Also, Controller instruction count needs to be adjusted.
				Controller.setInstructionNum(instStart);
			}
			else
			{
				//Otherwise, pop this off of the stack.
				Controller.RemoveSet();
			}
		}
	}
	
	public int getSize()
	{
		return inst.size();
	}
	
}
