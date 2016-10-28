package superbone;


/*
 * Small Class that implements the "clear" instruction.
 */
public class Clear implements Executable {

	private String varName;
	
	public Clear(String varName)
	{
		this.varName = varName;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Variables.clrVar(varName);
		
	}

}
