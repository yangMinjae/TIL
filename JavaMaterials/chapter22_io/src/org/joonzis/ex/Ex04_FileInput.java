package org.joonzis.ex;
import java.io.*;
public class Ex04_FileInput {

	public static void main(String[] args) {
		File file = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			file = new File("nationalAnthem.txt");
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = "";
			while(true) {
				line = br.readLine();
				if(line!=null) {
					System.out.println(line);
				}else {
					break;
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
