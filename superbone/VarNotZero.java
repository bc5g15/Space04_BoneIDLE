package superbone;

/*
 * The class describing the Variable Not Zero condition
 */
public class VarNotZero implements Conditional {

	private String varName;
	
	public VarNotZero(String varName)
	{
		this.varName = varName;
	}
	
	@Override
	public boolean Evaluate() {
		// TODO Auto-generated method stub
		if(Variables.GetVal(varName) != 0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
		
	}

}
