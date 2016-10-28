package boneIDLE;


public class EntryPoint {
	
	public static void main(String[] args)
	{
		//The program starts here.
		Swing2 s2 = new Swing2();
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				s2.BuildAndShow();
		}
		});
	}

}
