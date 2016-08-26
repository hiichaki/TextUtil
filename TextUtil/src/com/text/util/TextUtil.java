package com.text.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.text.model.Indexes;

public class TextUtil {

	public static String readFile(String path) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, StandardCharsets.UTF_8);
	}

	public static void findFieldinJsp(String text) {
		Indexes indexes = new Indexes(text, "<s:textfield", "/>");

		while (indexes.isValid()) {
			String field = text.substring(indexes.getBeginIndex(), indexes.getEndIndex());

		}

	}

	public static void findOccurenceInJsp(String text) {
		Indexes indexes = new Indexes(text, "key=\"", "\"");

	}

}
