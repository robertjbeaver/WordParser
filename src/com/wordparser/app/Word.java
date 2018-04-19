package com.wordparser.app;

public class Word {
	private String word = "";
	private int timesUsed = 0;
	public Word(String word, int timesUsed) {
		super();
		this.word = word;
		this.timesUsed = timesUsed;
	}
	public Word(String word) {
		super();
		this.word = word;
	}
	public Word() {
		super();
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getTimesUsed() {
		return timesUsed;
	}
	public void setTimesUsed(int timesUsed) {
		this.timesUsed = timesUsed;
	}
	@Override
	public String toString() {
		return word + " -- [ " + timesUsed + " ]";
	}
}
