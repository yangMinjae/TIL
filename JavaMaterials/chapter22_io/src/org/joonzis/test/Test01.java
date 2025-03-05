package org.joonzis.test;
import java.io.*;
public class Test01 {

	public static void main(String[] args) {
		File file; 
		FileReader fr = null;
		BufferedReader br = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			file= new File("nationalAnthem.txt");
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			fw = new FileWriter("nationalAnthem2.txt");
			bw = new BufferedWriter(fw);
			String line="";
			while(true) {
				line=br.readLine();
				if(line!=null) {
					System.out.println(line);
					bw.write(line);
					bw.write("\n");
					// or
					//bw.newLine();
				}else {
					break;
				}
			}
			bw.flush();
		} catch (IOException e) {
			// TODO: handle exception
		} finally {
			try {
				if(br!=null)br.close();
				if(fr!=null)fr.close();
				if(bw!=null)bw.close();
				if(fw!=null)fw.close();
			} catch (IOException e2) {
				// TODO: handle exception
			}

		}

		
	}
}
