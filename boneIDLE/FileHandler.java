package boneIDLE;

import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;

public class FileHandler {
	public static String ReadTest(File f, Charset c)
	{
		try
		{
			byte[] encoded = Files.readAllBytes(f.toPath());
			return new String(encoded, c);
		}
		catch(Exception e)
		{
			System.out.println("Something went wrong!");
			System.out.println(e);
		}
		return "";
	}
	
	public static void WriteTest(String s, File f)
	{
		try
		{
			PrintWriter pw = new PrintWriter(f.getAbsolutePath());
			pw.print(s);
			pw.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
