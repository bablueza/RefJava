package runtimePack;

public class TimeOut extends Thread
{
	Process proc;
	String output;
	int TIMESLEEP;
	public TimeOut(int timeSleep)
	{
		this.TIMESLEEP = timeSleep;
	}
	public void setProc(Process proc1)
	{
		this.proc = proc1;
		
	}
	public void setOutput(String output)
	{
		this.output = output;
		
	}
	public String getOutput()
	{
		return output;
		
	}
	public void run() {
		try {
			Thread.sleep(TIMESLEEP);
			proc.destroy();
			output = "Time Out";
			System.err.println("Time Out destroy process");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}