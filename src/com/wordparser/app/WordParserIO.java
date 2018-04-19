package com.wordparser.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WordParserIO {
	private File parsedFile = null;

	public WordParserIO() {
	}
	public static StringBuilder getText(File file)  {
		try(BufferedReader in = new BufferedReader(
				new FileReader(file))) {
			StringBuilder sb = new StringBuilder();
			String text = in.readLine();
			while(text != null) {
				sb.append(text);
				text = in.readLine();
			}
			return sb;
		} catch(IOException e ) {
			System.out.println(e);
			return null;
		}



	}
	private void createCheck() {
		try {
			if (!parsedFile.exists()) parsedFile.createNewFile();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
