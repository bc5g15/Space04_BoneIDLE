package superbone;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class FirstTest {
	
	private static String readFile() throws IOException
	{
		FileReader fr = new FileReader("TestFile");
		BufferedReader br = new BufferedReader(fr);
		
		String aLine;
		String finOut = "";
		while((aLine = br.readLine()) != null)
		{
			finOut += aLine;
		}
		
		fr.close();
		br.close();
		
		//System.out.println(finOut + "!");
		return finOut;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "";
		try
		{
			a = readFile();
			Reader.readBigFile(readFile());
			System.out.println(readFile());
		}
		catch(Exception e)
		{
			//Don't care
		}
		
		Reader.readBigFile("clear X;incr X;");
		Controller.FullRun();
		System.out.println("?" + a + "?");
		Variables.PrintVars();
	}

}
