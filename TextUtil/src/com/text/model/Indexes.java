package com.text.model;

public class Indexes {

	private int beginIndex;
	private int endIndex;
	private String text;
	private String beginString;
	private String endString;
	private String occurence;

	public Indexes(String text, String beginString, String endString) {
		this.beginIndex = text.indexOf(beginString);
		this.endIndex = text.indexOf(endString, beginIndex);
		this.text = text;
		this.beginString = beginString;
		this.endString = endString;
		if (isValid()) {
			this.occurence = text.substring(beginIndex, endIndex);
		} else {
			this.occurence = null;
		}
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

	public String getOccurence() {
		return occurence;
	}

	public void setOccurence(String occurence) {
		this.occurence = occurence;
	}

}
