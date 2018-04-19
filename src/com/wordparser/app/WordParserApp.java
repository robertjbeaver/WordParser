package com.wordparser.app;



import java.io.File;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class WordParserApp {
	public static void main(String[] args) {
		
		//welcome the user and get input
		System.out.println("Welcome to the Word Parser!");
		System.out.print("Enter the name of the file \n> ");
		Scanner sc = new Scanner(System.in);
		String filestr = sc.next();
		sc.close();
		
		//Set the file path equal to the input
		File file = new File(filestr);
		
		//generate the StringBuilder from the file
		StringBuilder sb = WordParserIO.getText(file);
		
		//Clean the file for parsing. Removes any non alpha
		sb = WordParserUtil.removeSpecialChars(sb);
		
		//split the cleaned data into an array of strings
		String[] arrayOfWords = sb.toString().split(" ");
		
		//generate a list of Word objects from that array of strings
		ArrayList<Word> wordsList = WordParserUtil.generateListOfWordObjects(arrayOfWords);
		
		//sort the array by times used
		wordsList = WordParserUtil.sortByTimesUsed(wordsList);
		
		//print the new list
		for(Word w: wordsList) System.out.println(w.toString());
		
		//log the list
		WordParserIO.writeLog(wordsList);
		
		
	// HashMaps are a way simpler solution to generating the Word and Values of times used
	// but the HashMap can't sort. There's a LinkedHashMap that can be iterated but that
	// seemed like it too needed a lot of extra code to be able to sort
		
		//HashMap<String, Integer> wordsMap = WordParserUtil.generateMapOfWords(arrayOfWords);
		//System.out.println(wordsMap.toString());





	}

}
