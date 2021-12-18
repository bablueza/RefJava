import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import runtimePack.TimeOut;

public class RumEXE 
{

	String CMD;
	BufferedReader readerEr;
	BufferedReader readerIn;
	int TIMESLEEP;
    public static void main(String[] args)
    { 
    	RumEXE RE = new RumEXE();
    	RE.setCmd("java -version");
    	RE.setTimeSleep(5000);
    	RE.startRumEXE();	
		try {
			String line;
			while((line = RE.gerStdErr().readLine())!=null)
			{
				System.out.println("getErrorStream "+line);
				
			}
			while((line = RE.gerStdIn().readLine())!=null)
			{
				System.out.println("getInputStream "+line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
    	
    		
    }
    
    public  RumEXE()
    {
    	TIMESLEEP = 5000;
    	CMD = "java -version";
    }
    public  void startRumEXE()
    {
    	String output = "";
    	Runtime r1 = Runtime.getRuntime();
		Process proc1;
		try {
			
			proc1 = r1.exec(CMD);
			TimeOut TO = new TimeOut(TIMESLEEP);
			TO.setProc(proc1);
			TO.start();
			
			try {
				proc1.waitFor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			readerEr = new BufferedReader(new InputStreamReader(proc1.getErrorStream()));
			readerIn = new BufferedReader(new InputStreamReader(proc1.getInputStream()));
			
			TO.setOutput(output);
			TO.stop();
			proc1.destroy();
			output =  TO.getOutput();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			output = "IOException";
			e.printStackTrace();
		}
		
    }
    public void setTimeSleep(int timeSleep)
	{
		this.TIMESLEEP = timeSleep;
	}
    public void setCmd(String cmd)
    {
    	this.CMD = cmd;
    }
    public BufferedReader gerStdErr()
    {
    	return readerEr;
    }
    public BufferedReader gerStdIn()
    {
    	return readerIn;
    }
}

