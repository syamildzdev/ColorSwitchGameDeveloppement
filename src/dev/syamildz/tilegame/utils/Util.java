package dev.syamildz.tilegame.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Util {
	
	public static String loadFileAsString(String path) {
		StringBuilder builder = new StringBuilder();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while(( line = br.readLine()) != null ) 
				builder.append(line + "\n");
			br.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return builder.toString();
	}
	
	public static int parseInt(String nb) {
		try {
			return Integer.parseInt(nb);
		}
		catch (NumberFormatException e){
			e.printStackTrace();
			return 0;
		}
	}
	
}
