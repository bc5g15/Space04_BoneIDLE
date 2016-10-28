package superbone;

/*
 * Simple class describing the Increment instruction
 */
public class Increment implements Executable {
	
	private String name;
	
	public Increment(String name)
	{
		this.name = name;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Variables.incVar(name);
	}

}
