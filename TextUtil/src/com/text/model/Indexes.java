package com.text.model;

public class Indexes {

	private int beginIndex;
	private int endIndex;

	public Indexes(String text, String begin, String end) {
		beginIndex = text.indexOf(begin);
		endIndex = text.indexOf(end, beginIndex);
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
