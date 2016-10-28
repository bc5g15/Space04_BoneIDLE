package superbone;

/*
 * This instruction pushes the program into a loop instruction set.
 * DEPRECATED: Use InstructionSet instead.
 * CORRECTION: This never actually worked
 */
public class EnterLoop implements Executable {
	private InstructionSet loop;
	private Conditional cond;
	
	public EnterLoop(InstructionSet is, Conditional c)
	{
		loop = is;
		cond = c;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		if(cond.Evaluate())
		{
			Controller.AddSet(loop);
			
		}

	}

}
