package com.text.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileUtil {
	
	public static String readFile(String path) {
		try {
			byte[] encoded = Files.readAllBytes(Paths.get(path));
			return new String(encoded, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public static ArrayList<String> allJspFiles(String path) {
		ArrayList<String> filesJsp = new ArrayList<String>();
		try {
			Files.walk(Paths.get(path)).forEach(filePath -> {
				if (Files.isRegularFile(filePath)) {
					String[] split = filePath.toString().split("\\.");
					String extension = split[split.length - 1].toLowerCase();
					if(extension.equals("jsp")) {
						filesJsp.add(filePath.getFileName().toString());
					}
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filesJsp;
	}
	
	public static void write(String text, String path) {
		try {
			File file = new File(path);
			PrintWriter writer = new PrintWriter(file.getAbsolutePath(), "UTF-8");
			writer.print(text);
			writer.close();
			System.out.println("writing: "+file.getAbsolutePath());
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
	
}
