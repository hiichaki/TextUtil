package com.text.model;

public class Indexes {

	private int beginIndex;
	private int endIndex;
	private String text;
	private String beginString;
	private String endString;
	private String occurence;

	public Indexes(String text, String beginString, String endString) {
		this.text = text;
		
		this.beginString = beginString;
		this.endString = endString;
		
		this.beginIndex = text.indexOf(beginString) + beginString.length();
		this.endIndex = text.indexOf(endString, beginIndex+2);
		
		if (isValid()) {
			this.occurence = text.substring(beginIndex, endIndex);
		} else {
			this.occurence = null;
		}
	}

	public boolean next() {
		this.beginIndex = text.indexOf(beginString, endIndex);
		this.endIndex = text.indexOf(endString, beginIndex);
		if(isValid()) {
			occurence = text.substring(beginIndex + beginString.length(), endIndex);
			return true;
		}
		return false;
	}

	public boolean isValid() {
		return (beginIndex > 0 && endIndex > 0);
	}

	@Override
	public String toString() {
		return "Indexes [beginIndex=" + beginIndex + ", endIndex=" + endIndex + "]";
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
