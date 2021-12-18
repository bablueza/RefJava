import ioPack.ReadFile;
import ioPack.WriteFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ByteMain {

	public ByteMain() {
		ReadFile RF = new ReadFile();
		WriteFile WF = new WriteFile();
		try {
			BufferedInputStream BISin = RF.newBufferedInputStream("Input\\text.txt");
			BufferedOutputStream FOSout = WF.newBufferedOutputStream("Output\\text.txt",false);
			
			long tmpSkip = BISin.skip(10);
	    	byte [] c = new byte [BISin.available()-(int)tmpSkip];
	    	BISin.read(c);
	    	FOSout.write(c);
	    	
	    	BISin.close();
			FOSout.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ByteMain();

	}

}
