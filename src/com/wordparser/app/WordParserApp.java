package com.wordparser.app;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class WordParserApp {
	public static void main(String[] args) {
		System.out.print("Enter the name of the file \n> ");
		Scanner sc = new Scanner(System.in);
		String filestr = sc.next();
		File file = new File(filestr);
		StringBuilder sb = WordParserIO.getText(file);
		sb = WordParserSB.clean(sb);
		String[] arrayOfWords = sb.toString().split(" ");
		ArrayList<Word> wordsList = WordParserSB.calculate(arrayOfWords);
		wordsList = WordParserSB.sortByTimesUsed(wordsList);
		for(Word w: wordsList) System.out.println(w.toString());
		//HashMap<String, Integer> wordsList = WordParserSB.calculateMap(words);
		//for(String word: words) System.out.print(word);
		
		
		
		

	}
	
}
