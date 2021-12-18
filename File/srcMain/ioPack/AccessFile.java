package ioPack;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AccessFile {

	public AccessFile() {
		// TODO Auto-generated constructor stub
	}
	public RandomAccessFile newRandomAccessFile(String fileName) throws FileNotFoundException
	{
		RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
		return raf;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AccessFile AF = new AccessFile();
			RandomAccessFile Rin = AF.newRandomAccessFile("Input\\text.txt");
			String line = null;
			while ((line = Rin.readLine()) != null)
			{
				System.out.println(line);
				Rin.seek(Rin.length());
			}
			Rin.close();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
