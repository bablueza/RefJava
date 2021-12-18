package ioPack;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
public class WriteFile
{
	public static void main(String[] args) 
	{
		WriteFile WF = new WriteFile();
		try {
			PrintWriter PWout = WF.newPrintWriter("Output\\text1.txt","TIS-620",true);
			PWout.print("1234\n");
			PWout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		try {
			BufferedWriter BWout = WF.newBufferedWriter("Output\\text2.txt");
			BWout.write(1);
			BWout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			BufferedOutputStream FOSout = WF.newBufferedOutputStream("Output\\text3.txt",true);
			FOSout.write(1);
			FOSout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public WriteFile() 
	{	
	}
	//encode = TIS-620, UTF-8
	//append = true, false
	public PrintWriter newPrintWriter(String fileName,String endode,boolean append) throws FileNotFoundException, UnsupportedEncodingException 
	{
		FileOutputStream fos = new FileOutputStream(fileName,append);
	    OutputStreamWriter osw = new OutputStreamWriter(fos, endode);
	    PrintWriter out = new PrintWriter(osw);
		return out;
	}
	//append = true, false
	public PrintWriter newPrintWriter(String fileName,boolean append) throws FileNotFoundException, UnsupportedEncodingException 
	{
		FileOutputStream fos = new FileOutputStream(fileName,append);
	    OutputStreamWriter osw = new OutputStreamWriter(fos);
	    PrintWriter out = new PrintWriter(osw);
		return out;
	}
	//long char int String
	//encode = TIS-620, UTF-8
	//append = true, false
	public BufferedWriter newBufferedWriter(String fileName,String endode,boolean append) throws FileNotFoundException, UnsupportedEncodingException 
	{
		FileOutputStream fos = new FileOutputStream(fileName,append);
	    OutputStreamWriter osw = new OutputStreamWriter(fos, endode);
	    BufferedWriter out = new BufferedWriter(osw);
		return out;
	}
	//long char int String
	//append = true, false
	public BufferedWriter newBufferedWriter(String fileName,boolean append) throws FileNotFoundException, UnsupportedEncodingException 
	{
		FileOutputStream fos = new FileOutputStream(fileName,append);
	    OutputStreamWriter osw = new OutputStreamWriter(fos);
	    BufferedWriter out = new BufferedWriter(osw);
		return out;
	}
	//String int char
	public BufferedWriter newBufferedWriter(String fileName) throws IOException 
	{
		FileWriter fw = new FileWriter(fileName);
		BufferedWriter out = new BufferedWriter(fw);
		return out;
	}
	//long byte int
	//append = true, false
	public BufferedOutputStream newBufferedOutputStream(String fileName,boolean append) throws FileNotFoundException 
	{
		FileOutputStream fos = new FileOutputStream (fileName,append);
		BufferedOutputStream out = new BufferedOutputStream(fos);
		return out;
	}

}
