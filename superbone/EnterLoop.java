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
		else
		{
			//Otherwise set forward the instruction count of the controller
			//DISCLAIMER: This is horrible code, but I can't immediately think of a better way to do this.
			Controller.adjustInstructionNumber(loop.getSize()+1);
		}

	}

}
