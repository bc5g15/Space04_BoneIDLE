package superbone;

/*
 * Container class for the Decrement instruction
 */
public class Decrement implements Executable {
	private String name;
	
	public Decrement(String name)
	{
		this.name = name;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Variables.decVar(name);

	}

}
