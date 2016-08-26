package com.text.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.text.model.Indexes;

public class TextUtil {

	static String property = readFile("");

	public static String readFile(String path) {
		try {
			byte[] encoded = Files.readAllBytes(Paths.get(path));
			return new String(encoded, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static void findFieldinJsp(String text) {
		Indexes indexes = new Indexes(text, "<s:textfield", "/>");
		String a = "<s:textarea key=";

		if (indexes.isValid()) {
			do {
				String field = indexes.getOccurence();
				String phrase = findOccurenceInField(field, "key=\"");
				phrase = findOccurenceInField(field, "label=\"");

			} while (indexes.next());
		}

	}

	public static String findOccurenceInField(String field, String beginString) {
		Indexes indexes = new Indexes(field, beginString, "\"");
		return indexes.getOccurence();
	}

	public static void findInProperty(String phrase) {

	}

}
