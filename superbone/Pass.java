package superbone;

/*
 * Basic Empty instruction
 */

public class Pass implements Executable {

	@Override
	public void execute() {
		//Emit a debug! This should never be run!
		System.out.println("Bad! Running an empty instruction!");

	}

}
