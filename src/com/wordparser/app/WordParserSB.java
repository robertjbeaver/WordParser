package com.wordparser.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class WordParserSB {

	// removes all non letters but leaves the spaces
	public static StringBuilder clean(StringBuilder sb) {
		StringBuilder cleanSB = new StringBuilder();
		for(int i = 0; i < sb.length(); i++) {
			if("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOVQRSTUVWXYZ ".indexOf(sb.substring(i,i+1)) != -1) {
				cleanSB.append(sb.substring(i, i+1));
			}
		} return cleanSB;
	} 


	public static HashMap<String, Integer> calculateMap(String[] arrayOfWords) {
		HashMap<String, Integer> wordMap = new HashMap<>();
		for(int i = 0; i < arrayOfWords.length; i++) {
			if(wordMap.containsKey(arrayOfWords[i])) {
				wordMap.put(arrayOfWords[i], wordMap.get(arrayOfWords[i])+1);
			} else {
				wordMap.put(arrayOfWords[i], 1);
			}
		} return wordMap;
	}	






	public static ArrayList<Word> calculate(String[] arrayOfWords){	
		ArrayList<Word> wordObjectList = new ArrayList<>(); 
		for(int i = 0; i< arrayOfWords.length; i++) {
			if(!listContains(wordObjectList, arrayOfWords[i]) && !arrayOfWords[i].equalsIgnoreCase(" ")) {
				Word newWord = new Word(arrayOfWords[i], 1);
				wordObjectList.add(newWord);
			} else {
				incrementTimesUsed(wordObjectList, arrayOfWords[i]);
			}	
		}return wordObjectList;
	}


	public static ArrayList<Word> sortByTimesUsed(ArrayList<Word> wordsList){
		int maxUsed = 0;
		int maxIndex = 0;
		ArrayList<Word> returdedWordList = new ArrayList<>();
		for(Word w: wordsList) {
			if(w.getTimesUsed()>maxUsed) {
				maxUsed=w.getTimesUsed();
			}
		}
		maxIndex = maxUsed;
		while(maxIndex >= 1) {
			for(Word w: wordsList) {
				if(w.getTimesUsed()==maxIndex) {
					returdedWordList.add(w);
				}
			}
			maxIndex--;
		}
		return returdedWordList;
	}
	

	private static boolean listContains(ArrayList<Word> wordsList, String passedWord) {
		for(Word w: wordsList) {
			if (w.getWord().equalsIgnoreCase(passedWord)){
				return true;
			} 
		} return false;
	}
	
	private static void incrementTimesUsed(ArrayList<Word> wordsList, String passedWord) {
		for(Word w: wordsList) {
			if(w.getWord().equalsIgnoreCase(passedWord)) w.setTimesUsed(w.getTimesUsed()+1);
		}
	}
}
