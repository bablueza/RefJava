import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import ioPack.ReadFile;
import ioPack.WriteFile;


public class lineMain {

	public lineMain() {
		ReadFile RF = new ReadFile();
		WriteFile WF = new WriteFile();
		try {
			BufferedReader BRin1 = RF.newBufferedReader("Input\\text.txt");
			PrintWriter PWout1 = WF.newPrintWriter("Output\\text11.txt",false);
			BufferedWriter BWout1 = WF.newBufferedWriter("Output\\text12.txt",false);
			
			BufferedReader BRin2 = RF.newBufferedReader("Input\\text.txt","UTF-8");
			PrintWriter PWout2 = WF.newPrintWriter("Output\\text21.txt","UTF-8",false);
			BufferedWriter BWout2 = WF.newBufferedWriter("Output\\text22.txt",false);
			
			BufferedReader BRin3 = RF.newBufferedReader("Input\\text.txt","UTF-8");
			PrintWriter PWout3 = WF.newPrintWriter("Output\\text31.txt","UTF-8",false);
			BufferedWriter BWout3 = WF.newBufferedWriter("Output\\text32.txt",false);
			
			String line = null;
			while ((line = BRin1.readLine()) != null)
			{
				System.out.println(line);
				PWout1.print(line+"\n");
				BWout1.write(line+"\n");
			}
			
			while ((line = BRin2.readLine()) != null)
			{
				System.out.println(line);
				PWout2.print(line+"\n");
				BWout2.write(line+"\n");
			}
			
			int c;
			while((c = BRin3.read())!=-1)
			{
				System.out.println(c);
				PWout3.print(c);
				BWout3.write(c);
			}
			BRin1.close();
			PWout1.close();
			BWout1.close();
			BRin2.close();
			PWout2.close();
			BWout2.close();
			BRin3.close();
			PWout3.close();
			BWout3.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new lineMain();

	}

}
