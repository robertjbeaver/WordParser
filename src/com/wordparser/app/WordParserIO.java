package com.wordparser.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class WordParserIO {
	static File parsedFile = new File("output.txt");

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
		public static void writeLog(ArrayList<Word> wordsList) {
			createCheck();
			try(BufferedWriter out = new BufferedWriter(
					new FileWriter(parsedFile))){
				for(Word w: wordsList) {
					out.write(w.toString());
					out.newLine();
				}
			} 
			catch(FileNotFoundException e) {
				System.out.println(e);
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}

	
	private static void createCheck() {
		try {
			if (!parsedFile.exists()) {
				parsedFile.createNewFile();
			} else {
				parsedFile.delete();
				parsedFile.createNewFile();
			}

		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
