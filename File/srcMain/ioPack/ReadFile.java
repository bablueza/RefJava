package ioPack;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
public class ReadFile //อ่านไฟล์เป็นบรรทัด
{
	public static void main(String[] args) 
	{
		ReadFile RF = new ReadFile();
		/*
		try {
			//BufferedReader BRin = RF.newReadFile("Input\\text.txt");
			BufferedReader BRin = RF.newBufferedReader("Input\\text.txt","TIS-620");
			String line = null;
			while ((line = BRin.readLine()) != null)
			{
				System.out.println(line);
			}
			BRin.close();
		} catch (FileNotFoundException e1) {
		
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
		
			e1.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		*/
		try {
			BufferedInputStream BISin = RF.newBufferedInputStream("Input\\text.txt");
			BISin.skip(3);
	    	byte [] c = new byte [BISin.available()-3];
	    	BISin.read(c);
	    	System.out.println(">>>>>>>>>>  "+c);
	    	BISin.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public ReadFile() 
	{	
	}
	//encode = TIS-620, UTF-8
	public BufferedReader newBufferedReader(String fileName,String encode) throws FileNotFoundException, UnsupportedEncodingException 
	{
		FileInputStream fis = new FileInputStream(fileName);
        InputStreamReader isr = new InputStreamReader(fis, encode);
        BufferedReader in = new BufferedReader(isr);
		return in;
	}
	public BufferedReader newBufferedReader(String fileName) throws FileNotFoundException 
	{
		FileReader fr = new FileReader(fileName);
		BufferedReader in = new BufferedReader(fr);
		return in;
	}
	//read byte int
	public BufferedInputStream newBufferedInputStream(String fileName) throws FileNotFoundException 
	{
		FileInputStream fis = new FileInputStream(fileName);
		BufferedInputStream in = new BufferedInputStream(fis);
		return in;
	}
}
