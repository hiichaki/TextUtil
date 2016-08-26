package com.text.model;

public class Indexes {

	private int beginIndex;
	private int endIndex;
	private String text;
	private String beginString;
	private String endString;

	public Indexes(String text, String beginString, String endString) {
		beginIndex = text.indexOf(beginString);
		endIndex = text.indexOf(endString, beginIndex);
		this.text = text;
		this.beginString = beginString;
		this.endString = endString;
	}

	public boolean next() {
		beginIndex = text.indexOf(beginString, endIndex);
		endIndex = text.indexOf(endString, beginIndex);
		return isValid();
	}

	public boolean isValid() {
		return (beginIndex > 0 && endIndex > 0);
	}

	public int getBeginIndex() {
		return beginIndex;
	}

	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

}
